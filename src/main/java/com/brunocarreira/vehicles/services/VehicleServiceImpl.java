package com.brunocarreira.vehicles.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunocarreira.vehicles.domain.Search;
import com.brunocarreira.vehicles.domain.Vehicle;

/*
 * @Author:	Bruno Carreira
 * 
 * Vehicle Service Implementation Class
 * 
 * Implements the most important Business logic of the App.
 */
@Service
public class VehicleServiceImpl implements VehicleService{

	/*
	 * If we had a SGBD, dataSource would be a JPA Repository, for example
	 * */
	@Autowired
	private JsonDSService dataSource;
	
	public void setDataSource(JsonDSService dataSource){
		this.dataSource = dataSource; 
	}
	
	/*
	 * Return the vehicle list from DataSource
	 * */
	private List<Vehicle> getVehicleListFromDS() throws MalformedURLException, IOException{
		Search search = dataSource.getSearch();
		
		if (search != null)
			if (search.getVehicleList()!=null)
				return search.getVehicleList();
			else
				return new ArrayList<Vehicle>();
		
		return null;
	}
	
	/*
		Print a list of all the cars, in ascending price order
	 */
	public List<Vehicle> getVehiclesAscPriceOrder() throws MalformedURLException, IOException{
		List<Vehicle> vehicles = getVehicleListFromDS();
		
		return vehicles.stream().sorted(Comparator.comparing(Vehicle::getPrice)).collect(Collectors.toList());
	}
	
	/*
		Using the table below, calculate the specification of the vehicles based on their SIPP.
	 */
	public List<Vehicle> getVehiclesSIPP() throws MalformedURLException, IOException{
		List<Vehicle> vehicles = getVehicleListFromDS();
		
		return vehicles;
	}

	/*
	Return the highest rated supplier per car type, descending order:
	It means that, for each car type, returns the highest rated supplier Vehicle 
	*/
	public List<Vehicle> getVehiclesHighSupplier() throws MalformedURLException, IOException{
		List<Vehicle> vehicles = getVehicleListFromDS();
	
		// First group by car type and its corresponding highest rated supplier Vehicle
		Map<String, Optional<Vehicle>> carTypeByMaxRating = vehicles.stream()
				.collect(Collectors.groupingBy(Vehicle::getCarType
						,Collectors.maxBy(Comparator.comparing(Vehicle::getRating))));
		// Then return the list of present Vehicles in rating DESC order
		return carTypeByMaxRating.values().stream()
				.filter(Optional::isPresent)
			    .map(Optional::get)
			    .sorted(Comparator.comparing(Vehicle::getRating).reversed())
			    .collect(Collectors.toList());
	}
	
	/*
	Give each vehicle a score based on the below breakdown, then combine this score with the suppliers rating.
	Print out a list of	vehicles, ordered by the sum of the scores in descending order
	*/
	public List<Vehicle> getVehiclesScore() throws MalformedURLException, IOException{
		List<Vehicle> vehicles = getVehicleListFromDS();

		return vehicles.stream()
				.sorted(Comparator.comparing(Vehicle::getCombinedScore).reversed())
				.collect(Collectors.toList());
	}
}
