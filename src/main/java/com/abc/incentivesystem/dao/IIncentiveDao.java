package com.abc.incentivesystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.incentivesystem.entity.Incentive;

public interface IIncentiveDao extends JpaRepository<Incentive, Integer>{
	
	@Query(value="select a from Incentive a where a.incentiveId= :id")
	public Optional<Incentive> getIncentiveByIncentiveId(@Param("id") int incentiveId);

}
