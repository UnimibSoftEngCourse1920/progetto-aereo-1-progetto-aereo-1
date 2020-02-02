import {Component, OnInit} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {User} from '../../class-for-entity/User';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  loggedUser;
  ticketsList: any = [];
  flight;

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    // to retrieve logged user data
    this.http.get(environment.apiUrl + '/user/' + sessionStorage.getItem('loggedUserId'))
      .subscribe(response => {
          this.loggedUser = response;
          this.ticketsList = this.loggedUser.tickets;
        }, error => {
          console.log('Error ', error);
        }
      );
  }

  deleteTicket(tickedId) {
    if (confirm('Vuoi annullare la prenotazione?')) {
      this.http.get(environment.apiUrl + '/delete-ticket/' + tickedId).subscribe(() => {
        alert('Biglietto eliminato!');
      }, error => {
        console.log('Error ', error);
      });
    }
  }

  buyTicket(flightId, points) {
    this.http.get(environment.apiUrl + '/ticket/buy/' + this.loggedUser + flightId + points + 'false').subscribe(() => {
      alert('Acquisto effettuato!');
    }, error => {
      console.log('Error ', error);
    });
  }


  buyTicketWithPoints(tickedId) {
    this.http.get(environment.apiUrl + '/ticket/' + tickedId).subscribe(response => {
      this.flight = response[0].flight;
    });
    if (this.loggedUser.fidelityCard.points >= this.flight.price) {
      this.deleteTicket(tickedId);
      this.buyTicket(this.flight.id, -(this.flight.price));
    } else {
      alert('Punti non sufficienti!');
    }
  }

  buyTicketWithMoney(tickedId) {
    this.http.get(environment.apiUrl + 'ticket' + tickedId).subscribe(response => {
      this.flight = response[0].flight;
    });
    if (this.loggedUser.fidelityCard !== null) {
      this.buyTicket(this.flight.id, (this.flight.price / 10));
    }
  }


}


