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

import com.cg.mts.entities.Admin;
import com.cg.mts.entities.TripBooking;
import com.cg.mts.service.IAdminService;


@RestController
@RequestMapping("/api/admin")
@Validated
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	
	@PostMapping("/login")
	public String adminLogin(@RequestBody Admin admin) {
		
		return adminService.LoginAdmin(admin);
	}
	

	@PostMapping("/insertadmin")
	
	public String addAdmin( @RequestBody Admin admin) {
		return adminService.insertAdmin(admin);
	}
	
	
	@PutMapping("/updateadmin/{id}")
	public Admin updateAdmin( @RequestBody Admin admin,@PathVariable("id") long id) {
		return adminService.updateAdmin(admin,id);
	}
	
	
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("adminId") int adminId) {
		return adminService.deleteAdmin(adminId);
	}
	

	@GetMapping("/getalltrips")
	public List<TripBooking> getAllTrips() {
		return adminService.getAllTrips();
	}


	@GetMapping("/gettripscabwise/{cabId}")
	public List<TripBooking> getTripsCabwise( @PathVariable("cabId") int cabId) {
		return adminService.getTripsCabwise(cabId);
	}
	

	@GetMapping("/gettripscustomerwise/{customerId}")
	public List<TripBooking> getTripsCustomerwise(@PathVariable("customerId") long customerId) {
		return adminService.getTripsCustomerwise(customerId);
	}
	
}
