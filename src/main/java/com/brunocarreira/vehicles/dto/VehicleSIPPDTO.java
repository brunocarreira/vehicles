package com.brunocarreira.vehicles.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Used only for JSON REST responses (better bandwidth use)
 * POJO Object to store Vehicle SIPP data to send to the client 
 * */
@XmlRootElement
public class VehicleSIPPDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private String sipp;
	
	private String name;
	
	private String carType;
	
	private String doorsType;
	
	private String transmission;
	
	private String fuelAC;
	
	public VehicleSIPPDTO(String sipp, String name, String carType, String doorsType, String transmission, String fuelAC) {
		this.sipp = sipp;
		this.name = name;
		this.carType = carType;
		this.doorsType = doorsType;
		this.transmission = transmission;
		this.fuelAC = fuelAC;
	}
	
	public String getSipp() {
		return sipp;
	}

	public void setSipp(String sipp) {
		this.sipp = sipp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getDoorsType() {
		return doorsType;
	}

	public void setDoorsType(String doorsType) {
		this.doorsType = doorsType;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelAC() {
		return fuelAC;
	}

	public void setFuelAC(String fuelAC) {
		this.fuelAC = fuelAC;
	}

}
