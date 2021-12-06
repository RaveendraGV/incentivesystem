package com.abc.incentivesystem.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.service.BookingService;



@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@PostMapping("/save")
	public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking) {
		Booking booking2 = bookingService.addBooking(booking);
		ResponseEntity<Booking> entity = new ResponseEntity<>(booking2, HttpStatus.CREATED);
		return entity;

	}

	@PostMapping("/update{id}")
	public ResponseEntity<Booking> updateBooking(@RequestBody Car car, @PathVariable("id") int bookingId) {
		Booking booking = bookingService.updateCarBooking(car, bookingId);
		return new ResponseEntity<>(booking, HttpStatus.OK);

	}

	@PostMapping("/delete{id}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("id") int bookingId) {
		Booking booking= bookingService.removeBookingById(bookingId);
		return new ResponseEntity<>(booking, HttpStatus.OK);
//		bookingService.removeBookingById(bookingId);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Booking>> fetchAllBooking() {
	List<Booking> bookings=	bookingService.getAllBooking();
		return new ResponseEntity<>(bookings, HttpStatus.OK);

	}

	@GetMapping("/get{id}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("id") int bookingId) {
		Booking booking = bookingService.getBookingById(bookingId);
		ResponseEntity<Booking> entity = new ResponseEntity<>(booking, HttpStatus.OK);
		return entity;
	}

}
