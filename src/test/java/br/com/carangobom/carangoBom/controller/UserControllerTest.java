package br.com.carangobom.carangoBom.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUsers() throws Exception {
        URI uri = new URI("/users");

        mockMvc
            .perform(MockMvcRequestBuilders
                .get(uri))
            .andExpect(MockMvcResultMatchers
                .status()
                .is(200));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        URI uri = new URI("/users");
        String json = "{\"user\":\"invalido@email.com\",\"password\":\"123456\"}";

        mockMvc
            .perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers
                .status()
                .is(201));
    }

    @Test
    public void shouldBeAbleToDeleteVehicleAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/users/1");

        mockMvc
            .perform(MockMvcRequestBuilders
                .delete(uri))
            .andExpect(MockMvcResultMatchers
                .status()
                .is(200));
    }

    @Test
    public void shouldThrowPasswordErrorWhenCreateUser() throws Exception {
        URI uri = new URI("/users");
        String json = "{\"user\":\"invalido@email.com\",\"password\":\"12\"}";
        String errorMsg = "\"field\":\"password\",\"message\":\"length must be between";

        MvcResult result = mockMvc
            .perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers
                .status()
                .is(400))
            .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        Assert.assertTrue(responseContent.contains(errorMsg));
    }

    @Test
    public void shouldThrowUserErrorWhenCreateUser() throws Exception {
        URI uri = new URI("/users");
        String json = "{\"user\":\"in\",\"password\":\"123456\"}";
        String errorMsg = "\"field\":\"user\",\"message\":\"length must be between";

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders
                    .post(uri)
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                    .status()
                    .is(400))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        Assert.assertTrue(responseContent.contains(errorMsg));
    }

}
