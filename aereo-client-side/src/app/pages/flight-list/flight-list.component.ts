import {Component, OnInit} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router'; // Importa classe voli


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {
  departureLocation;
  landingLocation;
  departureDay;
  flightList: any = [];
  data = [ // Test data
    {
      id: '2783',
      posti: 18,
      LP: 'Milano',
      LA: 'Mosca',
      DP: '08/09/2011', // non ho trovato format Data
      OP: '09:30',
      state: true, // false = Effettuato/cancellato, quindi non mostra in lista
    },
    {
      id: '1880',
      posti: 2,
      LP: 'Tokyo',
      LA: 'New York',
      DP: '11/09/2011', // non ho trovato format Data
      OP: '20:30',
      state: true, // false = Effettuato/cancellato, quindi non mostra in lista
    },
    {
      id: '2827',
      posti: 12,
      LP: 'New York',
      LA: 'Milano',
      DP: '15/07/2011', // non ho trovato format Data
      OP: '6:00',
      state: false, // false = Effettuato/cancellato, quindi non mostra in lista
    }
  ];

  constructor(private http: HttpClient,  private router: Router) {
  }

  ngOnInit() {

    this.http.get(environment.apiUrl + '/flights')
      .subscribe(response => {
          this.flightList = response;
        }, err => {
          console.log('Error: ' + err);
        }
      );

    /*this.departureLocation = sessionStorage.getItem('departureLocation');
    this.landingLocation = sessionStorage.getItem('landingLocation');
    this.departureDay = sessionStorage.getItem('departureDay');

    this.http.get(environment.apiUrl + '/flights/ ' + this.landingLocation + '/' + this.departureDay + '/' + this.departureLocation)
      .subscribe(response => {
          this.flightList = response;
        }, err => {
          alert('Error: ' + err);
        }
      );*/

  }

  buyTicket(event) {
    const target = event.target || event.srcElement || event.currentTarget;
    const idAttr = target.attributes.id;
    sessionStorage.setItem('flightId', idAttr.nodeValue);
    this.router.navigate(['/tickets']);
  }

}
