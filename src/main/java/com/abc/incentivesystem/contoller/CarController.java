package com.abc.incentivesystem.contoller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.abc.incentivesystem.entity.Booking;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;

	@PostMapping("/save")
	public ResponseEntity<Car> saveCar(@RequestBody Car car) {
		Car car2 = carService.addCar(car);
		ResponseEntity<Car> entity = new ResponseEntity<>(car2, HttpStatus.CREATED);
		return entity;

	}

	@PostMapping("/update{carId}")
	public ResponseEntity<Car> updateCarById(@Valid @RequestBody Car car, @PathVariable("carId") Integer carId) {
		Car car2 = carService.updateCarById(car, carId);
		return new ResponseEntity<>(car2, HttpStatus.OK);
	}

	@DeleteMapping("/delete{carId}")
	public ResponseEntity<String> deleteCarById(@PathVariable Integer carId) {
		carService.removeCarById(carId);
		ResponseEntity<String> entity = new ResponseEntity<>("Car has been deleted", HttpStatus.OK);
		return entity;
	}

	@GetMapping("/get")
	public ResponseEntity<List<Car>> fetchAllCar() {
		List<Car> cars = carService.getAllCar();
		return new ResponseEntity<>(cars, HttpStatus.OK);
	}

	@GetMapping("/get{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") int carId) {
		Car car = carService.getCarById(carId);
		ResponseEntity<Car> entity = new ResponseEntity<>(car, HttpStatus.OK);
		return entity;
	}

}
