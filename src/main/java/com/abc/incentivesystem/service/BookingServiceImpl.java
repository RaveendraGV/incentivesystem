package com.abc.incentivesystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abc.incentivesystem.dao.IBookingDao;
import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.exception.BookingNotExistException;
import com.abc.incentivesystem.exception.DuplicateBookingException;
import com.abc.incentivesystem.exception.InvalidBookingDetailsException;

/**
* The Booking Service Implementation class
* simply Overrides and implement the methods declared in service Interface.
*
* @author  Raveendra G V
*/

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private IBookingDao bookingDao;
	
	
	/**
	   * This method is used to add new Booking. 
	   * This makes use of JPA inbuilt methods save and findById.
	   * @param booking This is the parameter to save new booking.
	   * @exception DuplicateBookingException On input error.
	   * @return Booking This returns new booking.
	   */
	@Override
	public Booking addBooking(Booking booking) {		
		
		Optional<Booking> optionalbooking = bookingDao.findById(booking.getBookingId());
		if (optionalbooking.isPresent()) {
			throw new DuplicateBookingException("Booking Id" + booking.getBookingId() + " is already exist");
		}

		Booking newBooking = bookingDao.save(booking);
		return newBooking;
	}
	
	/**
	   * This method is used to update new car details in a Booking. 
	   * This makes use of JPA inbuilt method findById and manually declared method getBookingById.
	   * @param car, This is the parameter to save new car in booking.
	   * @param bookingId, This is the parameter to find the booking which needs to be edited.
	   * @exception InvalidBookingDetailsException On input error.
	   * @return Booking, This returns new booking.
	   */

	@Override
	public Booking updateCarBooking(Car car, int bookingId) throws InvalidBookingDetailsException {
		Optional<Booking> optionalBooking = bookingDao.getBookingByID(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new InvalidBookingDetailsException("Booking details are invalid");
		}

		Booking newbBooking = bookingDao.getById(bookingId);
		newbBooking.setCar(car);
		bookingDao.save(newbBooking);
		return newbBooking;
	}
	
	/**
	   * This method is used to remove existing booking details in a Booking. 
	   * This makes use of JPA inbuilt methods delete and findById.
	   * @param bookingId, This is the parameter to find the booking which needs to be deleted.
	   * @exception BookingNotExistException On input error.
	   * @return nothing.
	   */

	@Override
	public void removeBookingById(int bookingId) throws BookingNotExistException {
		Optional<Booking> optionalBooking = bookingDao.findById(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new BookingNotExistException("Booking is not exist with booking id" + bookingId);
		}
		bookingDao.delete(optionalBooking.get());

	}
	
	/**
	   * This method is used to display all the booking details. 
	   * This makes use of JPA inbuilt methods findAll.
	   * @return List of Booking.
	   */

	@Override
	public List<Booking> getAllBooking() {
		List<Booking> bookings = bookingDao.findAll();
		return bookings;
	}
	
	/**
	   * This method is used to display a particular booking details in a Booking. 
	   * This makes use of JPA inbuilt methods delete and findById.
	   * @param bookingId, This is the parameter to find the booking which needs to be displayed.
	   * @exception BookingNotExistException On input error.
	   * @return Booking, This returns new booking.
	   */

	@Override
	public Booking getBookingById(int bookingId) throws BookingNotExistException {

		Optional<Booking> optionalBooking = bookingDao.findById(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new BookingNotExistException("Booking is not exist with booking id" + bookingId);
		}
		return optionalBooking.get();
	}

}
