package com.cg.mts.exception;

public class TripBookingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TripBookingNotFoundException(String message) {
		super(message);
		
	}
	
}
