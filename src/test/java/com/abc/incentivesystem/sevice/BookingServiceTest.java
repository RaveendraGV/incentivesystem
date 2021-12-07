package com.abc.incentivesystem.sevice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.incentivesystem.dao.IBookingDao;
//import com.abc.incentivesystem.entity.Address;
import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
//import com.abc.incentivesystem.entity.Car;
//import com.abc.incentivesystem.entity.Customer;
//import com.abc.incentivesystem.entity.Incentive;
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

//		Car car=new Car();
//		car.setBrand("abc");
//		car.setCarId(123l);
//		car.setModel("abcd");
//		car.setRegistrationNo("a");
//		car.setYearOfManufaturing("2020");
//		
//		booking.setCar(car);
//		
//		Customer customer=new Customer();
//		customer.setCustomerId("1");
//		customer.setName("aa");
//		customer.setEmail("abc@abc.com");
//		customer.setContactNo("999");
//		
//		List<Address> addresses= new ArrayList<>();
//		Address address =new Address();
//		address.setDoorNo("45");
//		address.setCity("aaaa");
//		address.setState("aaaaa");
//		address.setPincode(12345);
//		addresses.add(address);
//		
//		customer.setAdresses(addresses);
//		
//		booking.setCustomer(customer);
//		
//		Incentive incentive=new Incentive();
//		incentive.setNoOfSales(5);
//		
//		booking.setIncentive(incentive);
//		
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
	public void testRemoveBookingById() {
		Booking booking = new Booking();
		booking.setBookingId(123);
		booking.setBookingDate(LocalDate.of(2020, 10, 10));
		booking.setCar(null);
		booking.setCustomer(null);
		booking.setIncentive(null);

		
		Booking booking1=bookingDao.findById(123).get();
		bookingDao.delete(booking1);
		Booking booking2=null;
		Optional<Booking> optionalBooking =bookingDao.findById(123);
		if (optionalBooking.isPresent()) {
			booking2=optionalBooking.get();
		}
		Assertions.assertThat(booking2).isNull();
	}
	@Test
	public void testRemoveBookingByIdThrowingException() {
		when(bookingDao.findById(123)).thenThrow(BookingNotExistException.class);
		assertThrows(BookingNotExistException.class, () -> bookingServiceImpl.getBookingById(123));
	}
	
	@Test
	public void testUpdateCarBooking() {
		
		Booking booking=bookingDao.findById(123).get();
		Car car=new Car();
		car.setBrand("abc");
		car.setCarId(123l);
		car.setModel("abcd");
		car.setRegistrationNo("a");
		car.setYearOfManufaturing("2020");
		
		booking.setCar(car);
		
		
//		booking.setCar(null);
		Booking newBooking=bookingDao.save(booking);
		assertThat(newBooking.getCar()).isEqualTo(car);
	}
	
	@Test
	public void testUpdateBookingByIdThrowingException() {
		Car car=new Car();

		when(bookingDao.findById(123)).thenThrow(InvalidBookingDetailsException.class);
		assertThrows(InvalidBookingDetailsException.class, () -> bookingServiceImpl.updateCarBooking(car, 123));
	}
	
	@Test
	public void testGetAllBooking() {
		List<Booking> bookings=bookingDao.findAll();
		Assertions.assertThat(bookings.size()).isGreaterThan(0);
	}
	
	@Test
	public void testAddBooking() {
		
		
		Booking booking = new Booking();
		booking.setBookingId(123);
		booking.setBookingDate(LocalDate.of(2020, 10, 10));
		booking.setCar(null);
		booking.setCustomer(null);
		booking.setIncentive(null);
		
		Optional<Booking> optionalBooking = Optional.of(booking);

		when(bookingDao.findById(123)).thenReturn(optionalBooking);
		bookingServiceImpl.addBooking(booking);
		verify(bookingDao, times(1)).save(booking);
	}
	
	@Test
	public void testAddateBookingByIdThrowingException() {
		Booking booking=new Booking();
		when(bookingDao.save(booking)).thenThrow(DuplicateBookingException.class);
		assertThrows(DuplicateBookingException.class, () -> bookingServiceImpl.addBooking(booking));
	}
	
	
}
