package com.cg.mts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cg.mts.entities.Driver;
import com.cg.mts.repository.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.cg.mts.entities.Cab;
import com.cg.mts.entities.Customer;
import com.cg.mts.entities.TripBooking;
//import com.cg.mts.exception.CabNotFoundException;
import com.cg.mts.exception.CustomerNotFoundException;
import com.cg.mts.exception.TripBookingNotFoundException;
import com.cg.mts.repository.ICustomerRepository;
import com.cg.mts.repository.ITripBookingRepository;

import javax.transaction.Transactional;


@Service
public class TripBookingService implements ITripBookingService{
	

	@Autowired
	private ITripBookingRepository iTripBookingRepository;
	
	@Autowired
	private ICustomerRepository iCustomerRepository;

	@Autowired
	private IDriverRepository  iDriverRepository;
	
	@Override
	@Transactional
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		

		Optional<Driver> driver = iDriverRepository.findById(1L);
		Optional<Customer> customer = iCustomerRepository.findById(201L);
		tripBooking.setDriver(driver.get());
		driver.get().setTrip(tripBooking);
		customer.get().setTrip(tripBooking);
		tripBooking.setCustomer(customer.get());

		return this.iTripBookingRepository.save(tripBooking);
	}
	
	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking, int id) {
		
		
		  TripBooking trip = iTripBookingRepository.findById(id).orElseThrow(()-> new TripBookingNotFoundException("Trip not found"));
		  
		  trip.setDriver(tripBooking.getDriver());
		  trip.setDistanceInKm(tripBooking.getDistanceInKm());
		  trip.setBill(tripBooking.getBill());
		  trip.setFromDateTime(tripBooking.getFromDateTime());
		  trip.setToDateTime(tripBooking.getToDateTime());
		  trip.setFromLocation(tripBooking.getFromLocation());
		  trip.setToLocation(tripBooking.getToLocation());
		  trip.setStatus(tripBooking.isStatus());
		 
		  return iTripBookingRepository.save(trip);
	}

	@Override
	public ResponseEntity<String> deleteTripBooking(int id) {
		
		Optional<TripBooking> tripBooking = iTripBookingRepository.findById(id);
		if (tripBooking.isPresent()) {
			iTripBookingRepository.deleteById(id);
			return new ResponseEntity<>("Trip deleted",HttpStatus.OK);
		} else
			throw new TripBookingNotFoundException("trip not found");
	}

	@Override
	public List<TripBooking> viewAllTripsCustomer(long customerId) {
		
		List<TripBooking> findAllTrips = iTripBookingRepository.findAll();
		List<TripBooking> tripList = new ArrayList<TripBooking>();
		for(int i=0; i<findAllTrips.size(); i++) {
			if(findAllTrips.get(i).getCustomer().getCustomerId() == customerId) {
				tripList.add(findAllTrips.get(i));
			}
		}
		return tripList;
	}

	@Override
	public String calculateBill(long customerId) {
		
		Customer cust = iCustomerRepository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("Customer not found."));
		List<TripBooking> findAllTrip = iTripBookingRepository.findAll();
		List<TripBooking> tripList = new ArrayList<TripBooking>();
		for(int i=0; i<findAllTrip.size(); i++) {
			if(findAllTrip.get(i).getCustomer().getCustomerId() == customerId) {
				tripList.add(findAllTrip.get(i));
			}
		}
		int size = tripList.size() - 1;
		String bill = "Total bill is: "+tripList.get(size).getBill();
		return bill;
	}

}
