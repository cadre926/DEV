import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reservation } from '../model/reservation.model';
import { ReservationService } from '../services/reservation.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent implements OnInit {

  private reservations! : Array<any>
  
  constructor(private reservationService: ReservationService, public router:Router ) { }

  
  
  
  ngOnInit() {
    this.handlegetAllReservations();
   
  }

  handlegetAllReservations(){

    this.reservationService.getALLReservations().subscribe({

      next: (data)=>{
        this.reservations=data;
      },

  });
  }

  handDeleteReservation(r:Reservation ){

    this.reservationService.deleteReservation(r.reservationId).subscribe(

      (data)=>{
        this.handlegetAllReservations();         
      });

    }

  onEditReservation(id:number){
      this.router.navigate(['edit-rervation',id] );
  }

 
  

}
