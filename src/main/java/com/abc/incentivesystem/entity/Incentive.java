package com.abc.incentivesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "incentive_tbl")
public class Incentive {

	@Id
	@Positive(message = "Only positiive numbers are allowed")
	@Column(name = "no_of_sales")
	private int noOfSales;

	public int getNoOfSales() {
		return noOfSales;
	}

	public void setNoOfSales(int noOfSales) {
		this.noOfSales = noOfSales;
	}
}
