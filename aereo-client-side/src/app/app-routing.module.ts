import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {RegistrationComponent} from './pages/registration/registration.component';
import {FlightListComponent} from './pages/flight-list/flight-list.component';
import {BuyComponent} from './pages/ticket/buy/buy.component';
import {PromoComponent} from './pages/promo/promo.component';


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
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: 'ticket/buy',
    component: BuyComponent
  },
  {
    path: 'promo',
    component: PromoComponent
  },
  {
    path: 'flight-list',
    component: FlightListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
