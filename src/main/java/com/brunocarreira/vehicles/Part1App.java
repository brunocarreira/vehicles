package com.brunocarreira.vehicles;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.brunocarreira.vehicles.domain.Vehicle;
import com.brunocarreira.vehicles.services.VehicleService;


/*
 * @Author:	Bruno Carreira
 * 
 * Exercise Part 1 (run as Java standard Application)
 * Client class
 */
public class Part1App 
{

	private static ConfigurableApplicationContext context;
	
	/*
	 * Start Spring Context only once
	 */
	private static ConfigurableApplicationContext getApplicationContext() {
		if (context == null) {
			context = SpringApplication.run(Part2App.class);
		}
		return context;
	}

	private static VehicleService getVehicleService(){
		return getApplicationContext().getBean(VehicleService.class);
	}
	
	/*
	 * Print a list of all the cars, in ascending price order, in the following format:
	 * 1. {Vehicle name} – {Price}
	 */
	private static void printVehiclesAscPriceOrder() throws IOException{
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);

		vehicles = getVehicleService().getVehiclesAscPriceOrder();
		System.out.println(VehicleService.LABEL_PRICE_ORDER);
		vehicles.forEach(v->System.out.println(atomicInteger.getAndIncrement() + ". " + v.getName() + " - " + v.getPrice()));
	}

	/*
	 * Using the table below, calculate the specification of the vehicles based on their SIPP. Print the specification out using the following format:
	 * 1. {Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con} 
	 */
	private static void printVehiclesSIPP() throws IOException{
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);

		vehicles = getVehicleService().getVehiclesSIPP();
		System.out.println("\n"+VehicleService.LABEL_SIPP);
		vehicles.forEach(v->System.out.println(atomicInteger.getAndIncrement() + ". " + v.getName() + 
																				" - " + v.getSipp() +
																				" - " + v.getCarType() +
																				" - " + v.getDoorsType() +
																				" - " + v.getTransmission() +
																				" - " + v.getFuelAC()));
	}

	/*
	 * Print out the highest rated supplier per car type, descending order, in the following format:
	 * 1. {Vehicle name} – {Car type} – {Supplier} – {Rating}
	 */
	private static void printVehiclesHighSupplier() throws IOException{
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);

		vehicles = getVehicleService().getVehiclesHighSupplier();
		System.out.println("\n"+VehicleService.LABEL_HIGHEST_RATED);
		vehicles.forEach(v->System.out.println(atomicInteger.getAndIncrement() + ". " + v.getName() + 
																				" - " + v.getCarType() +
																				" - " + v.getSupplier() +
																				" - " + v.getRating()));
	}

	/*
	 * Give each vehicle a score based on the below breakdown, then combine this score with the suppliers rating. Print out a list of
	 * vehicles, ordered by the sum of the scores in descending order, in the following format:
	 * 1. {Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
	 */
	private static void printVehiclesScore() throws IOException{
		AtomicInteger atomicInteger = new AtomicInteger(1);

		System.out.println("\n"+VehicleService.LABEL_SCORE);
		getVehicleService().getVehiclesScore().forEach(v->System.out.println(atomicInteger.getAndIncrement() + 
																				". " + v.getName() + 
																				" - " + v.getBreakdown() +
																				" - " + v.getRating() +
																				" - " + v.getCombinedScore()));
	}

	public static void main( String[] args )
    {
		try{
			printVehiclesAscPriceOrder();
			printVehiclesSIPP();
			printVehiclesHighSupplier();
			printVehiclesScore();
		} catch (IOException e) {
			System.out.println(VehicleService.DATASOURCE_ERROR);
		}

    }
}
