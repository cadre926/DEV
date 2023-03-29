import { Component, OnInit } from '@angular/core';
import { ReservationService } from '../services/reservation.service';

@Component({
  selector: 'app-new-reservation',
  templateUrl: './new-reservation.component.html',
  styleUrls: ['./new-reservation.component.css']
})
export class NewReservationComponent implements OnInit {

  constructor(public reservationService:ReservationService) { }

  ngOnInit() {
  }

  onSaveContact(DataForm){

    this.reservationService.saveReservation(DataForm).subscribe({

      next: (data)=>{

        console.log("OK");
        

         
      },

  })
    


  }

}
