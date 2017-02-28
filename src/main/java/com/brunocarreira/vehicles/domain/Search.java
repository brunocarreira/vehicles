package com.brunocarreira.vehicles.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * @Author:	Bruno Carreira
 * 
 * Container class for Vehicles (Domain class) 
 * */
@XmlRootElement
public class Search implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("VehicleList")
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	
}
