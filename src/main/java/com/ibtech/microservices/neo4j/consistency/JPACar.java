package com.ibtech.microservices.neo4j.consistency;


public class JPACar {

	private String make;

	private String model;

	private int year;

	JPACar() {
	}

	public JPACar(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return make + " " + model + " " + year;
	}

}
