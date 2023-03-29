package com.transdev.mybus.mapper;

import org.mapstruct.factory.Mappers;

import com.transdev.mybus.dto.ReservationDto;
import com.transdev.mybus.entities.Reservation;

public interface ReservationMapper {
	
	ReservationMapper MAPPER = Mappers.getMapper(ReservationMapper.class);

    ReservationDto mapToReservationDto(Reservation reservation);

    Reservation mapToReservation(ReservationDto reservationDto);

}
