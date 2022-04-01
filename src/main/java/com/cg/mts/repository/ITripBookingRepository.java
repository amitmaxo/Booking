package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mts.entities.TripBooking;

@Repository
public interface ITripBookingRepository extends JpaRepository<TripBooking, Integer>{

}