package com.globallogic.model;

public class Customer {

	private String name;
	private String gender;
	private long contactNumber;

	public Customer() {
		super();
	}

	public Customer(String name, String gender, long contactNumber) {
		super();
		this.name = name;
		this.gender = gender;
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", gender=" + gender + ", contactNumber=" + contactNumber + "]";
	}

}
