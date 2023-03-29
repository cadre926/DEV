package com.transdev.mybus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.mybus.entities.Bus;
import com.transdev.mybus.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
}