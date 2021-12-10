package com.abc.incentivesystem.service;

import java.util.List;

import com.abc.incentivesystem.entity.Incentive;
import com.abc.incentivesystem.entity.Incentive1;

public interface IncentiveService {

	public Incentive addIncentive(Incentive incentive);

	public void deleteIncentive(Incentive incentive);

	public List<Incentive> getAllIncentive();

	public Incentive getIncentiveById(int incentiveId);

	public Incentive updateIncentive(Incentive incentive, int incentiveId);

	public Incentive1 approveIncentive(int dealerId);

}
