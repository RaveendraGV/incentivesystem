package com.abc.incentivesystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.incentivesystem.entity.Car;

public interface ICarDao extends JpaRepository<Car, Integer>{
	
	@Query(value="select a from Car a where a.carId= :cId")
	public Optional<Car> getCarByID(@Param("cId") int carId);
	
	@Query(value="select count(*) from car_tbl where dealer_id=?",nativeQuery = true)
	public int saleCountByDealerId( int dealerId);

// @Query(value="select count(*) from car_tbl where dealer_id=? and (date columnName)=month(now())-1",nativeQuery = true)
//	@Query(value="select a from Car a where a.registration_no= :cregistratioNo")
//	public Optional<Car> getCarByRegistrationNo(@Param("cregistration_no") String registration_no);
	
//	@Query(value = "select a from Booking a where a.bookingId= :bId")
//  public Optional<Booking> getBookingByID(@Param("bId") int bookingId);
}

