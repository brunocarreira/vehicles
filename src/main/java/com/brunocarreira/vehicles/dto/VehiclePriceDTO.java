package com.brunocarreira.vehicles.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Used only for JSON REST responses (better bandwidth use)
 * POJO Object to store Vehicle and Price to send to the client 
 * */
@XmlRootElement
public class VehiclePriceDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private String name;
	
	private double price;
	
	public VehiclePriceDTO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
