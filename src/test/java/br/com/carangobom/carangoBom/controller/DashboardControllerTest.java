package br.com.carangobom.carangoBom.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class DashboardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeAbleToListTotalPriceOfBrandsAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/dashboard");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
}
