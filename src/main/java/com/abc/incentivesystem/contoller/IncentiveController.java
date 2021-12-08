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

//import com.abc.incentivesystem.entity.Booking;
//import com.abc.incentivesystem.entity.Car;
import com.abc.incentivesystem.entity.Incentive;
import com.abc.incentivesystem.entity.Incentive1;
import com.abc.incentivesystem.service.IncentiveService;

@RestController
@RequestMapping("/incentive")
public class IncentiveController {
	@Autowired
	public IncentiveService incentiveService;
	
	@PostMapping("/save")
	public ResponseEntity<Incentive> saveIncentive(@RequestBody Incentive incentive){
		Incentive incentive2=incentiveService.addIncentive(incentive);
		ResponseEntity<Incentive> entity= new ResponseEntity<>(incentive2, HttpStatus.CREATED);
		return entity;

	}
	
	@PostMapping("/update{id}")
	public ResponseEntity<Incentive> updateIncentive(@RequestBody Incentive incentive , @PathVariable("id") int incentiveId){
		Incentive incentive1 = incentiveService.updateIncentive(incentive , incentiveId);
		return new ResponseEntity<>(incentive1 , HttpStatus.OK);
				
	}
	
	@PostMapping("/delete{id}")
	public ResponseEntity<String> deleteIncentive(@RequestBody Incentive incentive) {
		incentiveService.deleteIncentive(incentive);
		return new ResponseEntity<>("Incentive has been deleted", HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Incentive>> fetchAllIncentive(){
		List<Incentive> incentive =incentiveService.getAllIncentive();
		return new ResponseEntity<>(incentive , HttpStatus.OK);
		
	}
	
	@GetMapping("/get{id}")
	public ResponseEntity<Incentive> getIncentiveByIncentiveId(@PathVariable("id") int incentiveId){
		Incentive incentive=incentiveService.getIncentiveById(incentiveId);
		ResponseEntity<Incentive> entity=new ResponseEntity<>(incentive, HttpStatus.OK);
		return entity;
	}
	
	@GetMapping("/getAllIncentive/{dealerId}")
	public ResponseEntity<Incentive1> getIncentive(@PathVariable int dealerId){
		Incentive1 incentive =incentiveService.approveIncentive(dealerId);
		return new ResponseEntity<>(incentive , HttpStatus.OK);
		
	}
	
}