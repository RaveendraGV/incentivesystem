package com.abc.incentivesystem.entity;



import java.time.LocalDate;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "booking_tbl")
public class Booking {



@Id
@Column(name = "booking_id")
private int bookingId;

@NotNull(message = "Localdate should not be empty")
@Column(name = "booking_date")
private LocalDate bookingDate;

@JsonManagedReference
@OneToOne(optional = false, cascade = CascadeType.ALL)
@JoinColumn(name = "customer_id")
private Customer customer;



@OneToOne(cascade = CascadeType.PERSIST)
private Car car;



@OneToOne(cascade = CascadeType.PERSIST)
private Incentive incentive;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
@JoinColumn(name="user_id",updatable = false, insertable = false)
private User user;



public int getBookingId() {
return bookingId;
}



public void setBookingId(int bookingId) {
this.bookingId = bookingId;
}



public LocalDate getBookingDate() {
return bookingDate;
}



public void setBookingDate(LocalDate bookingDate) {
this.bookingDate = bookingDate;
}



public Customer getCustomer() {
return customer;
}



public void setCustomer(Customer customer) {
this.customer = customer;
}



public Car getCar() {
return car;
}



public void setCar(Car car) {
this.car = car;
}



public Incentive getIncentive() {
return incentive;
}



public void setIncentive(Incentive incentive) {
this.incentive = incentive;
}



public User getUser() {
return user;
}



public void setUser(User user) {
this.user = user;
}
}