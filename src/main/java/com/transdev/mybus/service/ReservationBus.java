package com.transdev.mybus.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.transdev.mybus.entities.Bus;
import com.transdev.mybus.entities.Facture;
import com.transdev.mybus.entities.Reservation;
import com.transdev.mybus.enums.PaymentOption;
import com.transdev.mybus.repository.BusRepository;
import com.transdev.mybus.repository.FactureRepository;
import com.transdev.mybus.repository.ReservationRepository;

public class ReservationBus implements IReservationBus {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	FactureRepository factureRepository;
	@Autowired
	BusRepository busRepository;

	@Override
	public boolean payReservation(long idReservation) {

		return true;
	}

	// La facture(bill) se crée automatiquement quand une réservation est payée
	@Override
	public void saveFacture() {

		List<Reservation> reservations = reservationRepository.findAll();

		for (Reservation reservation : reservations) {
			if (payReservation(reservation.getReservationId())) {

				Facture facture = new Facture();
				facture.setFactureId(reservation.getReservationId());

				facture.setPaymentOption(PaymentOption.CARD);

				// Une remise de 5% est appliquée quand le prix du trajet est supérieur à 100
				// euros
				if (reservation.getBus().getPrix() > 100) {

					Bus bus = busRepository.findById(reservation.getBus().getBusId()).get();

					bus.setPrix(bus.getPrix() * 0.95);

					busRepository.save(bus);

				}

				factureRepository.save(facture);
			}

		}

	}

	// Trier les factures

	@Override
	public List<Facture> TrierFacture() {

		List<Facture> factures = factureRepository.findAll();

		List<Facture> sortedfactures = factures.stream().sorted(Comparator.comparingLong(Facture::getFactureId))
				.collect(Collectors.toList());

		return sortedfactures;

	}

}
