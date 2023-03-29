import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../model/reservation.model';
import { ReservationService } from '../services/reservation.service';

@Component({
  selector: 'app-edit-reservation',
  templateUrl: './edit-reservation.component.html',
  styleUrls: ['./edit-reservation.component.css']
})
export class EditReservationComponent implements OnInit {


  mode:number=1;
  
  reservation: Reservation;

  idReservation:number;

  constructor(public activateroute:ActivatedRoute,
    public reservationService:ReservationService) { 


    this.idReservation=activateroute.snapshot.params['id'];
  }

  ngOnInit() {

    this.reservationService.getReservation(this.idReservation).subscribe(data=>{
      this.reservation=data;

    })
    
    
  }
  
  
  
  updateReservation(){

    this.reservationService.updateReservation(this.reservation).subscribe(
      
      data=>{
        alert("Mise à ajour effectué")
      } )
  }
}
