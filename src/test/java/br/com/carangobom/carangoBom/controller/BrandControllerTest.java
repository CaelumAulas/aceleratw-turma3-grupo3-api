package br.com.carangobom.carangoBom.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")


public class BrandControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldBeAbleToDeleteBrandAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/brand/1");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void shouldBeDisableToDeleteMissingBrandAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/brand/1222");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }


    @Test
    public void shouldBeAbleToListAllBrandsAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/brand");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeAbleToShowBrandByIdAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/brand/2");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeDisableToShowBrandByMissingIdAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/brand/2121");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }
    @Test
    public void shouldBeAbleToUpdateBrandAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/brand/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(" \"name\":\"Nissan\" ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeDisableToUpdateBrandWithValidationErrorsAndReturnStatusCode400() throws Exception {
        URI uri = new URI("/brand/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content("  \"\" ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void shouldBeDisableToUpdateMissingBrandAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/brand/1000000");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(" \"name\":\"Nissan\" ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void shouldBeAbleToCreateABrandAndReturnStatusCode201() throws Exception {
        URI uri = new URI("/brand");


        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(" \"name\":\"Nissan\" ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }


    public void shouldBeDisableToCreateABrandWithValidationErrorsAndReturnStatusCode400() throws Exception {
        URI uri = new URI("/brand");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content("  \"\" ")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }



}