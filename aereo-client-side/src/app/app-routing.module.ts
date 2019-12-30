import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {LoginComponent} from "./pages/login/login.component";
import {ProfileComponent} from "./pages/profile/profile.component";
import {RegistrationComponent} from "./pages/registration/registration.component";
import {BuyTicketComponent} from "./pages/tickets/buy-ticket/buy-ticket.component";
import {FlightListComponent} from "./pages/flight-list/flight-list.component";


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: '/home',
    component: HomeComponent
  },
  {
    path: '/login',
    component: LoginComponent
  },
  {
    path: '/register',
    component: RegistrationComponent
  },
  {
    path: '/profile/{userId}',
    component: ProfileComponent
  },
  {
    path: '/tickets/buy-ticket/{flightId}',
    component: BuyTicketComponent
  },
  {
    path: '/tickets/edit-ticket/{ticketId}',
    component: BuyTicketComponent
  },
  {
    path: '/flight-list',
    component: FlightListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
