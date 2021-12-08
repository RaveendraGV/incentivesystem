package com.abc.incentivesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.incentivesystem.dao.ICarDao;
import com.abc.incentivesystem.dao.IIncentiveDao;
import com.abc.incentivesystem.dao.IIncentiveDao1;
import com.abc.incentivesystem.entity.Incentive;
import com.abc.incentivesystem.entity.Incentive1;

@Service
public class IncentiveImpl implements IncentiveService{
	
	@Autowired
	private ICarDao carDao;
	
	@Autowired
	private IIncentiveDao incentiveDao;
	
	@Autowired
	private IIncentiveDao1 incentiveDao1;

	@Override
	public Incentive addIncentive(Incentive incentive) {
		Incentive newIncentive= incentiveDao.save(incentive);
		return newIncentive;
	}

	@Override
	public void deleteIncentive(Incentive incentive) {
		incentiveDao.delete(incentive);
		
	}

	@Override
	public List<Incentive> getAllIncentive() {
		List<Incentive> incentive = incentiveDao.findAll();
		return incentive;
		
	}

	@Override
	public Incentive updateIncentive(Incentive incentive, int incentiveId) {
		Incentive newIncentive = incentiveDao.getById(incentiveId);
//		newIncentive.setBooking(incentive.getBooking());
//		newIncentive.setIncentiveId(incentive.getIncentiveId());
//		newIncentive.setNoOfSales(incentive.getNoOfSales());
//		newIncentive.setNoOfDays(incentive.getNoOfDays());
//		incentiveDao.save(newIncentive);
		
		return newIncentive;
	}

	@Override
	public Incentive getIncentiveById(int incentiveId) {
		Incentive incentive = incentiveDao.findById(incentiveId).get();
		return incentive;
	
	}

	@Override
	public Incentive1 approveIncentive(int dealerId) {
		
		int saleCount = carDao.saleCountByDealerId(dealerId);
		
		Incentive1 incentive= new Incentive1();
		if(saleCount>=5) {
			incentive.setIncentiveStatus("Approved");
			incentive.setDealerid(dealerId);
			incentive.setNoOfSales(saleCount);
		}
		else {
			incentive.setIncentiveStatus("Not Approved");
			incentive.setDealerid(dealerId);
			incentive.setNoOfSales(saleCount);
		}
		incentiveDao1.save(incentive);
		
		return incentive;
	}
}

