package com.brunocarreira.vehicles.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Used only for JSON REST responses (better bandwidth use)
 * POJO Object to store Vehicle to show highest rated supplier per car type 
 * */
@XmlRootElement
public class VehicleHighSupplierDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private String name;
	
	private String carType;
	
	private String supplier;
	
	private float rating;
	
	public VehicleHighSupplierDTO(String name, String carType, String supplier, float rating) {
		this.carType = carType;
		this.name = name;
		this.supplier = supplier;
		this.rating = rating;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
}
