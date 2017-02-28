package com.brunocarreira.vehicles.resource;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brunocarreira.vehicles.domain.Vehicle;
import com.brunocarreira.vehicles.dto.VehicleHighSupplierDTO;
import com.brunocarreira.vehicles.dto.VehiclePriceDTO;
import com.brunocarreira.vehicles.dto.VehicleSIPPDTO;
import com.brunocarreira.vehicles.dto.VehicleScoreDTO;
import com.brunocarreira.vehicles.resource.exceptions.DataSourceException;
import com.brunocarreira.vehicles.services.VehicleService;

/*
 * @Author:	Bruno Carreira
 * 
 * REST Controller
 * Resource for REST endpoints.
 * Responses in JSON and HTML  
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleResource {

	@Autowired
	VehicleService vehicleService;
	
	/*
	 * Endpoint to produce HTML output with List of all the cars, in ascending price order.
	 * Format:		1. {Vehicle name} – {Price}
	 */
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET, value = "/priceOrder")
	public String getVehiclesAscPriceOrderHTML() {
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);
		StringBuffer sbResult = new StringBuffer(VehicleService.LABEL_PRICE_ORDER+"<br/>");
		try {
			vehicles = vehicleService.getVehiclesAscPriceOrder();
			vehicles.forEach(v->sbResult.append(atomicInteger.getAndIncrement() + ". " + v.getName() + " - " + v.getPrice() +"<br/>"));
			return sbResult.toString();
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce JSON output with List of all the cars, in ascending price order.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/priceOrderJSON")
	public ResponseEntity<List<VehiclePriceDTO>> getVehiclesAscPriceOrderJSON() {
		try {
			return new ResponseEntity<List<VehiclePriceDTO>>(vehicleService.getVehiclesAscPriceOrder()
					.stream().map(v->new VehiclePriceDTO(v.getName(), v.getPrice()))
					.collect(Collectors.toList()),
					HttpStatus.OK);
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce HTML output with the specification of the vehicles based on their SIPP.
	 * Format:		1. {Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
	 */
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET, value = "/sipp")
	public String getVehiclesSIPPHTML() {
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);
		StringBuffer sbResult = new StringBuffer(VehicleService.LABEL_SIPP+"<br/>");
		try {
			vehicles = vehicleService.getVehiclesSIPP();
			vehicles.forEach(v->sbResult.append(atomicInteger.getAndIncrement() + ". " + v.getName() + 
					" - " + v.getSipp() +
					" - " + v.getCarType() +
					" - " + v.getDoorsType() +
					" - " + v.getTransmission() +
					" - " + v.getFuelAC() +
					"<br/>"));
			return sbResult.toString();
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce JSON output with the specification of the vehicles based on their SIPP.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/sippJSON")
	public ResponseEntity<List<VehicleSIPPDTO>> getVehiclesSIPPJSON() {
		try {
			return new ResponseEntity<List<VehicleSIPPDTO>>(vehicleService.getVehiclesAscPriceOrder()
					.stream().map(v->new VehicleSIPPDTO(v.getSipp(), v.getName(), v.getCarType(), v.getDoorsType(), v.getTransmission(), v.getFuelAC()))
					.collect(Collectors.toList()),
					HttpStatus.OK);
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce HTML output with the highest rated supplier per car type, descending order.
	 * Format:		1. {Vehicle name} – {Car type} – {Supplier} – {Rating}
	 */
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET, value = "/highSupplier")
	public String getVehiclesHighSupplierHTML() {
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);
		StringBuffer sbResult = new StringBuffer(VehicleService.LABEL_HIGHEST_RATED+"<br/>");
		try {
			vehicles = vehicleService.getVehiclesHighSupplier();
			vehicles.forEach(v->sbResult.append(atomicInteger.getAndIncrement() + ". " + v.getName() + 
					" - " + v.getCarType() +
					" - " + v.getSupplier() +
					" - " + v.getRating() +
					"<br/>"));
			return sbResult.toString();
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce JSON output with the highest rated supplier per car type, descending order.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/highSupplierJSON")
	public ResponseEntity<List<VehicleHighSupplierDTO>> getVehiclesHighSupplierJSON() {
		try {
			return new ResponseEntity<List<VehicleHighSupplierDTO>>(vehicleService.getVehiclesHighSupplier()
					.stream().map(v->new VehicleHighSupplierDTO(v.getName(), v.getCarType(), v.getSupplier(), v.getRating()))
					.collect(Collectors.toList()),
					HttpStatus.OK);
		} catch (IOException e) {
			//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce HTML output with the list of	vehicles, ordered by the sum of the scores in descending order.
	 * Format:		1. {Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
	 */
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE, method = RequestMethod.GET, value = "/score")
	public String getVehiclesScoreHTML() {
		List<Vehicle> vehicles;
		AtomicInteger atomicInteger = new AtomicInteger(1);
		StringBuffer sbResult = new StringBuffer(VehicleService.LABEL_SCORE+"<br/>");
		try {
			vehicles = vehicleService.getVehiclesScore();
			vehicles.forEach(v->sbResult.append(atomicInteger.getAndIncrement() + 
					". " + v.getName() + 
					" - " + v.getBreakdown() +
					" - " + v.getRating() +
					" - " + v.getCombinedScore() +
					"<br/>"));
			return sbResult.toString();
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

	/*
	 * Endpoint to produce JSON output with the list of	vehicles, ordered by the sum of the scores in descending order.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/scoreJSON")
	public ResponseEntity<List<VehicleScoreDTO>> getVehiclesScoreJSON() {
		try {
			return new ResponseEntity<List<VehicleScoreDTO>>(vehicleService.getVehiclesScore()
					.stream().map(v->new VehicleScoreDTO(v.getName(), v.getBreakdown(), v.getRating()))
					.collect(Collectors.toList()),
					HttpStatus.OK);
		} catch (IOException e) {
			throw new DataSourceException(VehicleService.DATASOURCE_ERROR);
		}
	}

}
