package com.transdev.mybus.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transdev.mybus.dto.ReservationDto;
import com.transdev.mybus.entities.Reservation;
import com.transdev.mybus.mapper.ReservationMapper;
import com.transdev.mybus.repository.ReservationRepository;

@RestController
public class ReservationRestController {

	private ReservationRepository reservationRepository;
	private ReservationMapper reservationMapper;

	public ReservationRestController(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
		super();
		this.reservationRepository = reservationRepository;
		this.reservationMapper = reservationMapper;
	}

	@GetMapping("/reservations")
	public List<ReservationDto> listReservations() {

		List<Reservation> reservations = reservationRepository.findAll();

		return reservations.stream().map((reservation) -> reservationMapper.MAPPER.mapToReservationDto(reservation))
				.collect(Collectors.toList());
	}

	@PostMapping("/reservations")
	public Reservation saveReservations(@RequestBody ReservationDto reservationDto) {

		Reservation reservation = reservationMapper.mapToReservation(reservationDto);

		return reservationRepository.save(reservation);
	}

	@PutMapping("/reservations/{id}")
	public Reservation updateReservations(@PathVariable long id, @RequestBody ReservationDto reservationDto) {

		Reservation reservation = reservationMapper.mapToReservation(reservationDto);

		reservation.setReservationId(id);

		return reservationRepository.save(reservation);
	}

	@DeleteMapping("/reservations/{id}")
	public void deteleReservations(@PathVariable long id) {

		reservationRepository.deleteById(id);
	}

}
