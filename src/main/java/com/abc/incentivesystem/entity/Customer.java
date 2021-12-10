package com.abc.incentivesystem.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer_tbl")
public class Customer {

	@Id
	@Column(name = "customer_id")
	private String customerId;

	@NotNull(message = "Please provide the customer name")
	@Column(name = " customer_name")
	private String name;

	@NotNull(message = "Please provide the customer phone number")
	@Column(name = "phone_no")
	private String contactNo;

	@NotNull(message = "Please provide the customer email")
	@Column(name = "email")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private List<Address> adresses = new ArrayList<>();

	@JsonBackReference
	@OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST)
	private Booking booking;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
