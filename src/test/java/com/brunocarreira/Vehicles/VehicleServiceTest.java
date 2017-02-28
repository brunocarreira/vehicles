package com.brunocarreira.Vehicles;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.brunocarreira.vehicles.Part2App;
import com.brunocarreira.vehicles.services.VehicleService;

/**
 * @author Bruno Carreira
 * 
 * Unit Test: Checking return of main functionality
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Part2App.class)
public class VehicleServiceTest {

	@Autowired
	private VehicleService vehicleService;
	
    @Test
    public void getVehiclesAscPriceOrderNotEmpty() throws IOException {
    	Assert.assertFalse(this.vehicleService.getVehiclesAscPriceOrder().isEmpty());
    }

    @Test
    public void getVehiclesSIPPNotEmpty() throws IOException {
    	Assert.assertFalse(this.vehicleService.getVehiclesSIPP().isEmpty());
    }

    @Test
    public void getVehiclesHighSupplierNotEmpty() throws IOException {
    	Assert.assertFalse(this.vehicleService.getVehiclesHighSupplier().isEmpty());
    }

    @Test
    public void getVehiclesScoreNotEmpty() throws IOException {
    	Assert.assertFalse(this.vehicleService.getVehiclesScore().isEmpty());
    }

}
