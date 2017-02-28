package com.brunocarreira.vehicles.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Used only for JSON REST responses (better bandwidth use)
 * POJO Object to store Vehicle score data 
 * */
@XmlRootElement
public class VehicleScoreDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private String name;
	
	private float breakdown;
	
	private float rating;
	
	private float combinedScore;
	
	public VehicleScoreDTO(String name, float breakdown, float rating) {
		this.name = name;
		this.rating = rating;
		this.breakdown = breakdown;
		this.combinedScore = rating+breakdown; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(float breakdown) {
		this.breakdown = breakdown;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getCombinedScore() {
		return combinedScore;
	}

	public void setCombinedScore(float combinedScore) {
		this.combinedScore = combinedScore;
	}
	
}
