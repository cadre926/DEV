import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../model/reservation.model';
import {map} from "rxjs/operators";

const baseUrl = 'http://localhost:8080/api/tutorials';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
 
  private reservations! : Array<Reservation>
  constructor(private http: HttpClient)  { 

    this.reservations=[

      {reservationId:1,dateReservation:"29/03/2023",busId:1,clientId:1},
      {reservationId:2,dateReservation:"25/03/2023",busId:2,clientId:2},
      {reservationId:3,dateReservation:"24/03/2023",busId:3,clientId:3}

    ]
     
  }

  public getALLReservations(){

    return this.http.get(baseUrl);
  }

  public deleteReservation(id:number){

    this.reservations= this.reservations.filter(r=>r.reservationId!=id);

    
 } 

 public saveReservation(reservation:Reservation){
  return this.http.post(baseUrl, reservation);
 }


 public getReservation(id:number) {
  
  return this.http.get(`${baseUrl}/${id}`).map(response => response.json());

 }

  

updateReservation(reservation:Reservation) {
  return this.http.put(`${baseUrl}/${reservation.reservationId}`, reservation);
}

 

 
 







}
