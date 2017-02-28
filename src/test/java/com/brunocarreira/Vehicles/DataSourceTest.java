package com.brunocarreira.Vehicles;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.brunocarreira.vehicles.Part2App;
import com.brunocarreira.vehicles.services.JsonDSService;

/**
 * @author Bruno Carreira
 * 
 * Unit Test: Check DataSource with the wrong URL
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Part2App.class)
@TestPropertySource(properties = { "datasource.url = www.google.com" })
public class DataSourceTest {

	@Autowired
	private JsonDSService jsonDSService;
	
    @Test(expected=IOException.class)
    public void wrongURL() throws IOException {
    	this.jsonDSService.getSearch();
    }

}
