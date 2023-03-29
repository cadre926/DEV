package com.transdev.mybus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
	
	private String reservationId;
	private String dateReservation;

}
