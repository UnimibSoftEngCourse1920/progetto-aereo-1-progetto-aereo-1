import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {RegistrationComponent} from './pages/registration/registration.component';
import {BuyTicketComponent} from './pages/tickets/buy-ticket/buy-ticket.component';
import {FlightListComponent} from './pages/flight-list/flight-list.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegistrationComponent
  },
  {
    path: 'profile',//TOLTO /{profileId} PER TESTARE
    component: ProfileComponent
  },
  {
    path: 'tickets/buy-ticket', //TOLTO /{flightId} PER TESTARE
    component: BuyTicketComponent
  },
  {
    path: 'tickets/edit-ticket', //TOLTO /{ticketId} PER TESTARE
    component: BuyTicketComponent
  },
  {
    path: 'flight-list',
    component: FlightListComponent
  }
  // To add: paymentform e promotions
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
