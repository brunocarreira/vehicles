package com.brunocarreira.Vehicles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.brunocarreira.vehicles.Part2App;
import com.brunocarreira.vehicles.domain.Search;
import com.brunocarreira.vehicles.domain.Vehicle;
import com.brunocarreira.vehicles.services.JsonDSService;
import com.brunocarreira.vehicles.services.VehicleService;
import com.brunocarreira.vehicles.util.Letter1Enum;
import com.brunocarreira.vehicles.util.Letter4Enum;

/**
 * @author Bruno Carreira
 * 
 * Unit Test using Mocks: just an example of test. Should be much more elaborated to assess more controls
 * 
 * The main functionality of the Application is tested here
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Part2App.class)
public class MockedVehicleServiceTest {

	@SpyBean
    private VehicleService vehicleService;

	@SpyBean
    private JsonDSService jsonDSService;

    @Before
    public void setup() throws IOException {
    	List<Vehicle> mockedVehicleList = new ArrayList<Vehicle>();
    	mockedVehicleList.add(new Vehicle("IWMR", "Ford Focus", 157.85, "Hertz", 8.9f));
    	mockedVehicleList.add(new Vehicle("MWMR", "Car2", 107.85, "Hertz", 8.4f));
    	mockedVehicleList.add(new Vehicle("EWMR", "Car3", 167.85, "Hertz", 7.9f));
    	mockedVehicleList.add(new Vehicle("IBMN", "Car4", 127.85, "Hertz", 9.9f));
    	Search search = new Search();
    	search.setVehicleList(mockedVehicleList);

    	// Mock Datasource
    	Mockito.when(jsonDSService.getSearch())
		.thenReturn(search);
    	
    	vehicleService.setDataSource(jsonDSService);
    }
	
    @Test
    public void checkGetVehiclesAscPriceOrder() throws IOException {
    	List<Vehicle> vehiclesOrdered;
    	vehiclesOrdered = vehicleService.getVehiclesAscPriceOrder();
    	Assert.assertTrue(vehiclesOrdered.get(0).getPrice()==107.85);
    	Assert.assertTrue(vehiclesOrdered.get(1).getPrice()==127.85);
    	Assert.assertTrue(vehiclesOrdered.get(2).getPrice()==157.85);
    	Assert.assertTrue(vehiclesOrdered.get(3).getPrice()==167.85);
    }

    @Test
    public void checkGetVehiclesSipp() throws IOException {
    	List<Vehicle> vehiclesSipp;
    	vehiclesSipp = vehicleService.getVehiclesSIPP();
    	Assert.assertTrue(vehiclesSipp.get(0).getCarType().equals(Letter1Enum.I.getValue()));
    	Assert.assertTrue(vehiclesSipp.get(1).getCarType().equals(Letter1Enum.M.getValue()));
    	Assert.assertTrue(vehiclesSipp.get(2).getCarType().equals(Letter1Enum.E.getValue()));
    	Assert.assertTrue(vehiclesSipp.get(3).getFuelAC().equals(Letter4Enum.N.getValue()));
    }

    @Test
    public void checkGetVehiclesHighSupplier() throws IOException {
    	List<Vehicle> vehiclesHighSupplier;
    	vehiclesHighSupplier = vehicleService.getVehiclesHighSupplier();
    	Assert.assertTrue(vehiclesHighSupplier.get(0).getName().equals("Car4"));
    	Assert.assertTrue(vehiclesHighSupplier.get(1).getName().equals("Car2"));
    	Assert.assertTrue(vehiclesHighSupplier.get(2).getName().equals("Car3"));
    }

    @Test
    public void checkGetVehiclesScore() throws IOException {
    	List<Vehicle> vehiclesScore;
    	vehiclesScore = vehicleService.getVehiclesScore();
    	Assert.assertTrue(vehiclesScore.get(0).getCombinedScore()==11.9f);
    	Assert.assertTrue(vehiclesScore.get(1).getCombinedScore()==11.4f);
    	Assert.assertTrue(vehiclesScore.get(2).getCombinedScore()==10.9f);
    	Assert.assertTrue(vehiclesScore.get(3).getCombinedScore()==10.9f);
    }

}
