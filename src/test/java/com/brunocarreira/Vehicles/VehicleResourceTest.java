package com.brunocarreira.Vehicles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.brunocarreira.vehicles.Part2App;

/**
 * @author Bruno Carreira
 * 
 * Integration Test: Check REST Controllers response type and status
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Part2App.class)
@WebAppConfiguration
public class VehicleResourceTest {

    private MediaType contentTypeJson = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MediaType contentTypeHtml = new MediaType(MediaType.TEXT_HTML.getType(),
            MediaType.TEXT_HTML.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void checkResultGetVehiclesAscPriceOrderJSON() throws Exception {
    	this.mockMvc.perform(get("/vehicles/priceOrderJSON"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeJson));

    }

    @Test
    public void checkResultGetVehiclesAscPriceOrderHTML() throws Exception {
    	this.mockMvc.perform(get("/vehicles/priceOrder"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeHtml));

    }

    @Test
    public void checkResultGetVehiclesSIPPJSON() throws Exception {
    	this.mockMvc.perform(get("/vehicles/sippJSON"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeJson));

    }

    @Test
    public void checkResultGetVehiclesSIPPHTML() throws Exception {
    	this.mockMvc.perform(get("/vehicles/sipp"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeHtml));

    }

    @Test
    public void checkResultGetVehiclesHighSupplierJSON() throws Exception {
    	this.mockMvc.perform(get("/vehicles/highSupplierJSON"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeJson));

    }

    @Test
    public void checkResultGetVehiclesHighSupplierHTML() throws Exception {
    	this.mockMvc.perform(get("/vehicles/highSupplier"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeHtml));

    }

    @Test
    public void checkResultGetVehiclesScoreJSON() throws Exception {
    	this.mockMvc.perform(get("/vehicles/scoreJSON"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeJson));

    }

    @Test
    public void checkResultGetVehiclesScoreHTML() throws Exception {
    	this.mockMvc.perform(get("/vehicles/score"))
			        .andExpect(status().isOk())
			        .andExpect(content().contentType(contentTypeHtml));

    }

}
