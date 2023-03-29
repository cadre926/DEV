package com.transdev.mybus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.mybus.entities.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {
	
}