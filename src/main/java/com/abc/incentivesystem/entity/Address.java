package com.abc.incentivesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "adress_tbl")
public class Address {

	@Id
	@Column(name = "door_no")
	private String doorNo;
	
	@NotEmpty(message = "Please provide a city name")
	@Column(name = "city")
	private String city;
	
	@NotEmpty(message = "Please provide a state name")
	@Column(name = "state")
	private String state;
	
	@NotNull(message = "Pincode Should not be empty")
	@Column(name = "pincode")
	private int pincode;
	
//	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
