package com.abc.incentivesystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "incentive_tbl1")
public class Incentive1 {
@Id
@Column(name = "dealer_id")
private int dealerid;

@Column(name = "incentive_Status")
private String incentiveStatus;

@Column(name = "no_of_sales")
private int noOfSales;

public int getDealerid() {
	return dealerid;
}

public void setDealerid(int dealerid) {
	this.dealerid = dealerid;
}

public String getIncentiveStatus() {
	return incentiveStatus;
}

public void setIncentiveStatus(String incentiveStatus) {
	this.incentiveStatus = incentiveStatus;
}

public int getNoOfSales() {
	return noOfSales;
}

public void setNoOfSales(int noOfSales) {
	this.noOfSales = noOfSales;
}




	
}
