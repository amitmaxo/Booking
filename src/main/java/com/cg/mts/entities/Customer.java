package com.cg.mts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Customer extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customer_Sequence")
    @SequenceGenerator(name = "customer_Sequence", sequenceName = "CUSTOMER_SEQ", initialValue = 201)
	private long customerId;

	@OneToOne(mappedBy = "customer")
	@JsonIgnore
	private TripBooking trip;
	


	public Customer() {
		super();
	}

	public Customer(long joinId, String username, String password, String mobileNumber, String email, long customerId) {
		super(username, password, mobileNumber, email);
		this.customerId = customerId;
	}

	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public TripBooking getTrip() {
		return trip;
	}

	public void setTrip(TripBooking trip) {
		this.trip = trip;
	}
}
