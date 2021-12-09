package com.abc.incentivesystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "incentive_tbl")
public class Incentive {

	@Id
	@Column(name = "incentive_id")
	private int incentiveId;

	@Column(name = "no_of_sales")
	private int noOfSales;

	@Column(name = "no_of_days")
	private int noOfDays;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Booking booking;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	public int getIncentiveId() {
		return incentiveId;
	}

	public void setIncentiveId(int incentiveId) {
		this.incentiveId = incentiveId;
	}

	public int getNoOfSales() {
		return noOfSales;
	}

	public void setNoOfSales(int noOfSales) {
		this.noOfSales = noOfSales;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}