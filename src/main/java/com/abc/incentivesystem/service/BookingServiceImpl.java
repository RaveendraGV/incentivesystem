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

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private IBookingDao bookingDao;

	@Override
	public Booking addBooking(Booking booking) {
		Optional<Booking> optionalbooking = bookingDao.findById(booking.getBookingId());
		if (optionalbooking.isPresent()) {
			throw new DuplicateBookingException("Booking Id" + booking.getBookingId() + " is already exist");
		}

		Booking newBooking = bookingDao.save(booking);
		return newBooking;
	}

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

	@Override
	public void removeBookingById(int bookingId)throws BookingNotExistException  {
		Optional<Booking> optionalBooking = bookingDao.findById(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new BookingNotExistException("Booking is not exist with booking id" + bookingId);
		}
//		bookingDao.deleteById(bookingId);
//		Booking booking = bookingDao.findById(bookingId).get();
		bookingDao.delete(optionalBooking.get());
//		return booking;

	}

	@Override
	public List<Booking> getAllBooking() {
		List<Booking> bookings = bookingDao.findAll();
		return bookings;
	}

	@Override
	public Booking getBookingById(int bookingId) throws BookingNotExistException {

		Optional<Booking> optionalBooking = bookingDao.findById(bookingId);
		if (optionalBooking.isEmpty()) {
			throw new BookingNotExistException("Booking is not exist with booking id" + bookingId);
		}
		return optionalBooking.get();
	}

}
