package com.cg.mts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.TripBooking;
import com.cg.mts.service.ITripBookingService;


@RestController
@RequestMapping("/api/tripbook")

@Validated
public class TripBookingController {

	@Autowired
	private ITripBookingService tripBookingService;
	
	
	@PostMapping("/inserttrip")
	public TripBooking insertTripBooking( @RequestBody TripBooking tripBooking) {
		return tripBookingService.insertTripBooking(tripBooking);
	}
	
	
	@PutMapping("/updatetrip/{id}")
	public TripBooking updateTripBooking( @RequestBody TripBooking tripBooking, @PathVariable("id")int id) {
		return tripBookingService.updateTripBooking(tripBooking,id);
	}
	
	
	@DeleteMapping("/deletetrip/{id}")
	public ResponseEntity<String> deleteTripBooking(  @PathVariable("id")int id) {
		return tripBookingService.deleteTripBooking(id);
	}
	
	
	@GetMapping("/viewalltripscustomer/{id}")
	public List<TripBooking> viewAllTripsCustomer( @PathVariable("id") int customerId){
		return tripBookingService.viewAllTripsCustomer(customerId);
	}
	
	
	@GetMapping("/customerbill/{id}")
	public String calculateBill( @PathVariable("id") long customerId) {
		return tripBookingService.calculateBill(customerId);
	}
}
