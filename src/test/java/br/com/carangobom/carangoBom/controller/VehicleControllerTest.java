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
public class VehicleControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldBeAbleToDeleteVehicleAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/vehicle/1");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void shouldBeDisableToDeleteInexistingVehicleAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/vehicle/1222");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }


    @Test
    public void shouldBeAbleToListAllVehiclesAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/vehicle");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeAbleToShowVehiclesByIdAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/vehicle/2");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeDisableToShowVehiclesByMissingIdAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/vehicle/2121");

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get(uri))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }
    @Test
    public void shouldBeAbleToUpdateVehiclesAndReturnStatusCode200() throws Exception {
        URI uri = new URI("/vehicle/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        //"brandId":"1",
                        .content("{  \"model\":\"Fusla\",\"year\":2020 ,\"brand_id\":\"1\",\"price\":10000.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }
    @Test
    public void shouldBeDisableToUpdateVehiclesWithValidationErrorsAndReturnStatusCode400() throws Exception {
        URI uri = new URI("/vehicle/1");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content("{  \"model\":\"Fusla\",\"year\":2020 ,\"brand_id\":\"1\",\"price\":-10000.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void shouldBeDisableToUpdateMissingVehiclesAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/vehicle/1000000");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content("{  \"model\":\"Fusla\",\"year\":2020 ,\"brand_id\":\"1\",\"price\":10000.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }
    @Test
    public void shouldBeDisableToUpdateVehiclesWithMissingBrandsAndReturnStatusCode404() throws Exception {
        URI uri = new URI("/vehicle/1000000");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content("{  \"model\":\"Fusla\",\"year\":2020 ,\"brand_id\":\"10\",\"price\":10000.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(404));
    }

    @Test
    public void shouldBeAbleToCreateAVehicleAndReturnStatusCode201() throws Exception {
        URI uri = new URI("/vehicle");


        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content("{ \"brand_id\":\"1\", \"model\":\"Fuskaa\",\"year\":2020 ,\"price\":2210.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }
    public void shouldBeDisableToCreateAVehicleWithMissingBrandAndReturnStatusCode409() throws Exception {
        URI uri = new URI("/vehicle");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content("{ \"brand_id\":\"1212121\", \"model\":\"Fuskaa\",\"year\":2020 ,\"price\":2210.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(409));
    }

    public void shouldBeDisableToCreateAVehicleWithValidationErrosAndReturnStatusCode400() throws Exception {
        URI uri = new URI("/vehicle");
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content("{ \"brand_id\":\"1\", \"model\":\"\",\"year\":1200 ,\"price\":-10.00 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }



}