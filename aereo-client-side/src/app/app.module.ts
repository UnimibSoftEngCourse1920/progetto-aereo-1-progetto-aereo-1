import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {CoreModule} from "./core/core.module";
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { BuyTicketComponent } from './pages/tickets/buy-ticket/buy-ticket.component';
import { EditTicketComponent } from './pages/tickets/edit-ticket/edit-ticket.component';
import { FlightListComponent } from './pages/flight-list/flight-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    ProfileComponent,
    BuyTicketComponent,
    EditTicketComponent,
    FlightListComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        CoreModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
