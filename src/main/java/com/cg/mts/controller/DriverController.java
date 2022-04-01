package com.cg.mts.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.cg.mts.entities.Driver;
import com.cg.mts.service.IDriverService;



@RestController
@RequestMapping("/api/driver")

@Validated
public class DriverController {

	@Autowired
	private IDriverService driverService;
	

	@PostMapping("/login")
	public String driverLogin( @RequestBody Driver driver) {
		
		return driverService.LoginDriver(driver);
	}
	
	
	@PostMapping("/insertdriver")
	public String insertDriver( @RequestBody Driver driver) {
		return driverService.insertDriver(driver);
	}
	

	@PutMapping("/updatedriver/{id}")
	public Driver updateDriver( @Valid @RequestBody Driver driver, @PathVariable("id")long id) {
	return driverService.updateDriver(driver,id);
	}
	

	@DeleteMapping("/deletedriver/{id}")
	public ResponseEntity<Driver> deleteDriver( @PathVariable("id")long id) {
		return driverService.deleteDriver(id);
	}
	

	@GetMapping("/viewdriver/{id}")
	public Driver viewDriver( @PathVariable("id") long id) {
	return driverService.viewDriver(id);
	}
	

	@GetMapping("/viewbestdriver")
	public List<Driver> viewBestDrivers() {
		return driverService.viewBestDrivers();
	}
}