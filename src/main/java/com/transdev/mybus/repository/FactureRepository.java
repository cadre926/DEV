package com.transdev.mybus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transdev.mybus.entities.Bus;
import com.transdev.mybus.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> { 

}
