package com.abc.incentivesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "car_tbl")
public class Car {

	@Id
	@Column(name = "car_id")
	private long carId;

	@NotNull(message = "Please provide the brand")
	@Column(name = "brand")
	private String brand;

	@NotNull(message = "Please provide the model")
	@Column(name = "model")
	private String model;

	@NotNull(message = "Please provide year of manufacturing")
	@Column(name = "year_of_mfg")
	private String yearOfManufaturing;

	@NotNull(message = "Please provide the registration number")
	@Column(name = "registration_no")
	private String registrationNo;

	@OneToOne // (cascade = CascadeType.ALL)
	private Booking booking;

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearOfManufaturing() {
		return yearOfManufaturing;
	}

	public void setYearOfManufaturing(String yearOfManufaturing) {
		this.yearOfManufaturing = yearOfManufaturing;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
