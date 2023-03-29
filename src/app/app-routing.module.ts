import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditReservationComponent } from './edit-reservation/edit-reservation.component';
import { NewReservationComponent } from './new-reservation/new-reservation.component';
import { ReservationsComponent } from './reservations/reservations.component';


const routes: Routes = [

{path:"reservations",component:ReservationsComponent},
{path:"new-rervation",component:NewReservationComponent},
{path:"edit-rervation/:id",component:EditReservationComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
