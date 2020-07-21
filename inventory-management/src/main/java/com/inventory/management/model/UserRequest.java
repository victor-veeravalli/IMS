package com.inventory.management.model;

public class UserRequest {
	
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String address;
	
	private String city;
	private String state;
	private String country;
	
	private Number mobileNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Number getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Number mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
