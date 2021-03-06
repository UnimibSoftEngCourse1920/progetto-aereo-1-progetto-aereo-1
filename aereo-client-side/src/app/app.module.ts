import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CoreModule} from './core/core.module';
import {HomeComponent} from './pages/home/home.component';
import {LoginComponent} from './pages/login/login.component';
import {RegistrationComponent} from './pages/registration/registration.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {FlightListComponent} from './pages/flight-list/flight-list.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {BuyComponent} from './pages/ticket/buy/buy.component';
import {PromoComponent} from './pages/promo/promo.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    ProfileComponent,
    FlightListComponent,
    BuyComponent,
    PromoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CoreModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
