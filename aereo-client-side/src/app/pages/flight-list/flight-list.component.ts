import {Component, OnInit} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  flightList: any = [];
  promoList: any = [];
  departureLocation;
  landingLocation;
  departureDay;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {

    /*this.http.get(environment.apiUrl + '/flights')
      .subscribe(response => {
          this.flightList = response;
        }, err => {
          console.log('Error: ' + err);
        }
      );*/

    this.departureLocation = sessionStorage.getItem('departureLocation');
    this.landingLocation = sessionStorage.getItem('landingLocation');
    this.departureDay = sessionStorage.getItem('departureDay');

    this.http.get(environment.apiUrl + '/flights/ ' + this.landingLocation + '/' + this.departureDay + '/' + this.departureLocation)
      .subscribe(response => {
          this.flightList = response;
        }, err => {
          alert('Error: ' + err);
        }
      );

    this.http.get(environment.apiUrl + '/promo')
      .subscribe(response => {
          this.promoList = response;
        }, err => {
          console.log('Error: ' + err);
        }
      );

    for (let flight of this.flightList) {
      for (let promo of this.promoList) {
        if ((flight.id === promo.flight) || ((flight.departureDay > promo.start) && (flight.departureDay < promo.end))) {
          if (promo.premium && (sessionStorage.getItem('loggedUserId') === undefined)) {
            break;
          } else {
            flight.price = flight.price - ((flight.price * promo.discountPercentage) / 100);
            flight.inPromo = true;
          }
        }
      }
    }
  }

  buyTicket(event) {
    const target = event.target || event.srcElement || event.currentTarget;
    const idAttr = target.attributes.id;
    sessionStorage.setItem('flightId', idAttr.nodeValue);
    this.router.navigate(['/ticket/buy']);
  }

}
