package com.transdev.mybus.service;

import java.util.List;

import com.transdev.mybus.entities.Facture;

public interface IReservationBus {
	
	
	void  saveFacture ();
	
	boolean payReservation(long idReservation);
	
	List<Facture> TrierFacture();

}
