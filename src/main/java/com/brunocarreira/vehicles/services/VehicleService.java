package com.brunocarreira.vehicles.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.brunocarreira.vehicles.domain.Vehicle;

/*
 * @Author:	Bruno Carreira
 * 
 * Vehicle Service Interface
 *   
 */
public interface VehicleService {

	/*
	 * If I had to build a real client App, I'd put those constants into a .properties file
	 * */
	public static final String LABEL_PRICE_ORDER = "List of all the cars, in ascending price order";
	public static final String LABEL_SIPP = "Specification of the vehicles based on their SIPP";
	public static final String LABEL_HIGHEST_RATED = "Highest rated supplier per car type, descending order";
	public static final String LABEL_SCORE = "Vehicles, ordered by the sum of the scores in descending order";
	public static final String DATASOURCE_ERROR = "Error reading DataSource";

	public void setDataSource(JsonDSService dataSource);

	public List<Vehicle> getVehiclesAscPriceOrder() throws MalformedURLException, IOException;
	
	public List<Vehicle> getVehiclesSIPP() throws MalformedURLException, IOException;
	
	public List<Vehicle> getVehiclesHighSupplier() throws MalformedURLException, IOException;
	
	public List<Vehicle> getVehiclesScore() throws MalformedURLException, IOException;
}
