import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from '../../../../environments/environment';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {

  loggedUser;
  flightChosen;
  promoList: any = [];
  reserved;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
    const flightId = sessionStorage.getItem('flightId');
    this.http.get(environment.apiUrl + '/flights/' + flightId)
      .subscribe(response => {
          this.flightChosen = response;
        }, err => {
          console.log('Error: ', err);
        }
      );

    const loggedUserId = sessionStorage.getItem('loggedUserId');
    if (loggedUserId !== undefined) {
      this.http.get(environment.apiUrl + '/users/' + loggedUserId)
        .subscribe(response => {
            this.loggedUser = response;
          }, err => {
            console.log('Error: ' + err);
          }
        );
    }
    this.http.get(environment.apiUrl + 'promo').subscribe(response => {
      this.promoList = response;
    }, error => console.log('error', error));
  }

  buyTicket() {
    this.http.get(environment.apiUrl + '/ticket/buy/' + this.loggedUser + this.flightChosen + this.reserved).subscribe(response => {
      this.router.navigate(['/home']);
    }, err => {
      console.log('Error: ' + err);
    });
  }


  buyTicketWithPoints() {
    if (this.loggedUser.fidelityCard.points >= this.flightChosen.price) {
      this.buyTicket();
    } else {
      alert('Punti non sufficienti!');
    }
  }

  buyTicketWithMoney() {
    // this.http.post( environment.apiUrl + 'tickets/save')
    if (this.loggedUser.fidelityCard !== null) {
      this.buyTicket();
    }
  }

}


