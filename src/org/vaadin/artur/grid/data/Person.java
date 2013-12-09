package org.vaadin.artur.grid.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Person implements Serializable {
	private int _employeeId;
	private String firstName="", lastName="";
	private Date birthDate;
	private BigDecimal salary ;
	private Address address;

	public Person() {

	}

	public Person(int _employeeId, String firstName, String lastName, Date birthDate,
			BigDecimal salary, Address address) {
		super();
		this._employeeId = _employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.salary = salary;
		this.address = address;
	}

	public int get_employeeId() {
		return _employeeId;
	}

	public void set_employeeId(int _employeeId) {
		this._employeeId = _employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
