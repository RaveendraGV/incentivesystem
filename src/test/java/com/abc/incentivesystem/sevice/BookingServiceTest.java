package com.abc.incentivesystem.sevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
//import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.incentivesystem.dao.IBookingDao;
import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.exception.BookingNotExistException;
import com.abc.incentivesystem.exception.DuplicateBookingException;
import com.abc.incentivesystem.exception.InvalidBookingDetailsException;
import com.abc.incentivesystem.service.BookingServiceImpl;

@SpringBootTest
public class BookingServiceTest {

	@Mock
	private IBookingDao bookingDao;

	@InjectMocks
	private BookingServiceImpl bookingServiceImpl;

	@Test
	public void testGetBookingById() {

		Booking booking = new Booking();
		booking.setBookingId(123);
		booking.setBookingDate(LocalDate.of(2020, 10, 10));
		booking.setCar(null);
		booking.setCustomer(null);
		booking.setIncentive(null);

		Optional<Booking> optionalBooking = Optional.of(booking);
		when(bookingDao.findById(123)).thenReturn(optionalBooking);
		Booking booking2 = bookingServiceImpl.getBookingById(123);
		assertEquals(booking.getBookingId(), booking2.getBookingId());
	}

	@Test
	public void testGetBookingByIdThrowingException() {
		when(bookingDao.findById(123)).thenThrow(BookingNotExistException.class);
		assertThrows(BookingNotExistException.class, () -> bookingServiceImpl.getBookingById(123));
	}

	@Test
	public void testRemoveBookingByIdThrowingException() {
		when(bookingDao.findById(123)).thenThrow(BookingNotExistException.class);
		assertThrows(BookingNotExistException.class, () -> bookingServiceImpl.getBookingById(123));
	}

	@Test
	public void testUpdateBookingByIdThrowingException() {
		Car car = new Car();

		when(bookingDao.findById(123)).thenThrow(InvalidBookingDetailsException.class);
		assertThrows(InvalidBookingDetailsException.class, () -> bookingServiceImpl.updateCarBooking(car, 123));
	}

	@Test
	public void testAddateBookingByIdThrowingException() {
		Booking booking = new Booking();
		when(bookingDao.save(booking)).thenThrow(DuplicateBookingException.class);
		assertThrows(DuplicateBookingException.class, () -> bookingServiceImpl.addBooking(booking));
	}

}
