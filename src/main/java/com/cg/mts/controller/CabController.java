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

import com.cg.mts.entities.Cab;
import com.cg.mts.service.ICabService;



@RestController
@RequestMapping("/api/cab")

@Validated
public class CabController {

	@Autowired
	private ICabService iCabService;
	

	@PostMapping("/insertcab")
	public Cab insertCab( @RequestBody Cab cab) {
		return iCabService.insertCab(cab);
	}

	@PutMapping("/updatecab/{id}")
	public Cab updateCab( @RequestBody Cab cab, @PathVariable("id") int id) {
		return iCabService.updateCab(cab,id);
	}
	
	
	@DeleteMapping("/deletecab/{id}")
	public ResponseEntity<String> deleteCab( @PathVariable("id") int id){
		return iCabService.deleteCab(id);
	}
	

	@GetMapping("/viewcabstype/{type}")
	public List<Cab> viewCabsOfType( @PathVariable("type")String type) {
		return iCabService.viewCabsOfType(type);
	}
	

	@GetMapping("/countcabs/{type}")
	public int countCabsOfType( @PathVariable("type")String type) {
		return iCabService.countCabsOfType(type);
	}
}