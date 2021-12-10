package com.abc.incentivesystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.incentivesystem.dao.ICarDao;
import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.exception.CarNotExistException;
import com.abc.incentivesystem.exception.DuplicateCarDetailException;
import com.abc.incentivesystem.exception.InvalidCarDetailsException;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private ICarDao carDao;

	@Override
	public Car addCar(Car car) throws DuplicateCarDetailException {
		Optional<Car> optionalCar = carDao.getCarByID(car.getCarId());
		if (optionalCar.isPresent()) {
			throw new DuplicateCarDetailException("Car Id " + car.getCarId() + " is already exist");
		}

		Car newCar = carDao.save(car);
		return newCar;
	}

	@Override
	public Car updateCarById(Car car, int carId) throws InvalidCarDetailsException {
		Optional<Car> optionalCar = carDao.findById(carId);
		if (optionalCar.isEmpty()) {
			throw new InvalidCarDetailsException("Car details are invalid");
		}

		Car newCar = carDao.findById(carId).get();
		newCar.setCarId(car.getCarId());
		newCar.setBrand(car.getBrand());
		newCar.setDealerId(car.getDealerId());
		newCar.setModel(car.getModel());
		newCar.setRegistrationNo(car.getRegistrationNo());
		newCar.setYearOfManufaturing(car.getYearOfManufaturing());
		newCar.setBooking(car.getBooking());
		carDao.save(newCar);
		return newCar;
	}

	@Override
	public void removeCarById(int carId) throws InvalidCarDetailsException {
		Optional<Car> optionalCar = carDao.findById(carId);

		if (optionalCar.isEmpty()) {
			throw new InvalidCarDetailsException("Car details should not be null");

		}
		carDao.delete(optionalCar.get());
	}

	@Override
	public List<Car> getAllCar() {
		List<Car> cars = carDao.findAll();
		return cars;
	}

	@Override
	public Car getCarById(int carId) throws CarNotExistException {

		Optional<Car> optionalCar = carDao.getCarByID(carId);
		if (optionalCar.isEmpty()) {
			throw new CarNotExistException("Car details not exist with " + carId + " this car id");
		}
		Car car = carDao.findById(carId).get();
		return car;
	}

}
