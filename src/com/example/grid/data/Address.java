package com.example.grid.data;

import java.io.Serializable;

public class Address implements Serializable {
	private String streetName="";
	private String city="";
	private Country country;

	public Address(String streetName, String city, Country country) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.country = country;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streeName) {
		this.streetName = streeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
