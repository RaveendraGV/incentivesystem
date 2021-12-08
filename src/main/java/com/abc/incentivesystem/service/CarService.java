package com.abc.incentivesystem.service;

import java.util.List;

import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.exception.CarNotExistException;
import com.abc.incentivesystem.exception.DuplicateCarDetailException;
import com.abc.incentivesystem.exception.InvalidCarDetailsException;

public interface CarService {

	public Car addCar(Car car) throws DuplicateCarDetailException;
	public Car updateCarById(Car car,int carId) throws InvalidCarDetailsException;
	public void removeCarById(int carId) throws InvalidCarDetailsException;
	public List<Car> getAllCar();
	public Car getCarById(int carId) throws CarNotExistException;
}

//-removeCar(long id):Car

//-getCar(long id):

//-getAllCars(): List<Car> public Car getCar(int carId); 
//-getCarsByLocation():List<Car>
//-getCarsByModel():List<Car>
//-getCarsByBrand():List<Car>
