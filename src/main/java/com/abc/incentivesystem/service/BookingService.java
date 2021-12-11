package com.abc.incentivesystem.service;

import java.util.List;

import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.exception.BookingNotExistException;
import com.abc.incentivesystem.exception.InvalidBookingDetailsException;

/**
* The Booking Service Interface
* Creating methods to perform CRUD operations
*
* @author  Raveendra G V
*/

public interface BookingService {
	public Booking addBooking(Booking booking);

	public Booking updateCarBooking(Car car, int bookingId) throws InvalidBookingDetailsException;

	public void removeBookingById(int bookingId) throws BookingNotExistException;

	public List<Booking> getAllBooking();

	public Booking getBookingById(int bookingId) throws BookingNotExistException;

}
