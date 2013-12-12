package org.vaadin.artur.grid.data;

import java.io.Serializable;

public class Address implements Serializable {
	private String _streetName = "";
	private String city = "";
	private Country country;

	public Address(String _streetName, String city, Country country) {
		super();
		this._streetName = _streetName;
		this.city = city;
		this.country = country;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String get_streetName() {
		return _streetName;
	}

	public void set_streetName(String _streetName) {
		this._streetName = _streetName;
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
