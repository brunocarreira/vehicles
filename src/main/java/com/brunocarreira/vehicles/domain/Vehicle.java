package com.brunocarreira.vehicles.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.brunocarreira.vehicles.util.Letter1Enum;
import com.brunocarreira.vehicles.util.Letter2Enum;
import com.brunocarreira.vehicles.util.Letter3Enum;
import com.brunocarreira.vehicles.util.Letter4Enum;

/*
 * @Author:	Bruno Carreira
 * 
 * POJO Object to store Vehicle data came from JSON (Domain class) 
 * */
@XmlRootElement
public class Vehicle implements Serializable{


	private static final long serialVersionUID = 1L;

	private String sipp;
	
	private String name;
	
	private double price;
	
	private String supplier;
	
	private float rating;

	public Vehicle(){
	}

	public Vehicle(String sipp, String name, double price, String supplier, float rating){
		this.sipp = sipp;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
		this.rating = rating;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
	
	// Returns the Breakdown score, based on sipp attribute
	public float getBreakdown(){
		float score = 0;
		
		try{
			if (sipp != null){
				String transmission = sipp.substring(2, 3);
				if(transmission.equals("M"))
					score+=1;
				else if(transmission.equals("A"))
					score+=5;

				String fuelAC = sipp.substring(3, 4);
				if(fuelAC.equals("R"))
					score+=2;
			}
		}
		catch(IndexOutOfBoundsException e){
			// No error! Don't increment score
			// If there's only 3 letters, consider the correspondent score
		}
		
		return score;
	}
	
	public float getCombinedScore(){
		return this.rating + getBreakdown();
	}
	
	// Calculated attribute based on SIPP attribute
	public String getCarType() {
		String carType="";
		try{
			carType = Letter1Enum.valueOf(sipp.substring(0, 1)).getValue();
		} catch (IllegalArgumentException | NullPointerException e) {
			carType="Invalid Car Type";
		}
		return carType;
	}

	// Calculated attribute based on SIPP attribute
	public String getDoorsType() {
		String doorsType="";
		try{
			doorsType = Letter2Enum.valueOf(sipp.substring(1, 2)).getValue();
		} catch (IllegalArgumentException | NullPointerException e) {
			doorsType="Invalid Doors Type";
		}

		return doorsType;
	}

	// Calculated attribute based on SIPP attribute
	public String getTransmission() {
		String transmission="";
		try{
			transmission = Letter3Enum.valueOf(sipp.substring(2, 3)).getValue();
		} catch (IllegalArgumentException | NullPointerException e) {
			transmission="Invalid Transmission";
		}

		return transmission;
	}

	// Calculated attribute based on SIPP attribute
	public String getFuelAC() {
		String fuelAC="";
		try{
			fuelAC = Letter4Enum.valueOf(sipp.substring(3, 4)).getValue();
		} catch (IllegalArgumentException | NullPointerException e) {
			fuelAC="Invalid Fuel/AC";
		}

		return fuelAC;
	}

}
