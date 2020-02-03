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
  reserved = false;
  canReserve;

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

    for (let ticket of this.loggedUser.tickets) {
      if ((ticket.flight.id === flightId) && ticket.reserved) {
        this.canReserve = false;
      }
    }
    this.http.get(environment.apiUrl + '/promo').subscribe(response => {
      this.promoList = response;
      for (let promo of this.promoList) {
        if ((this.flightChosen.id === promo.flight) ||
          ((this.flightChosen.departureDay > promo.start) && (this.flightChosen.departureDay < promo.end))) {
          if (promo.premium && (sessionStorage.getItem('loggedUserId') === undefined)) {
            break;
          } else {
            this.flightChosen.price = this.flightChosen.price - ((this.flightChosen.price * promo.discountPercentage) / 100);
            this.flightChosen.inPromo = true;
          }
        }
      }
    }, error => console.log('error', error));
  }

  buyTicket(points) {
    if (this.loggedUser !== undefined) {
      this.http.get(environment.apiUrl + '/ticket/buy/' + this.loggedUser + this.flightChosen + points + this.reserved).subscribe(() => {
        alert('Acquisto effettuato!');
        this.router.navigate(['/']);
      }, error => {
        console.log('Error ', error);
      });
    } else {
      this.router.navigate(['/']);
    }
  }

  buyTicketWithPoints() {
    if (this.loggedUser.fidelityCard.points >= this.flightChosen.price) {
      this.buyTicket(-this.flightChosen.price);
    } else {
      alert('Punti non sufficienti!');
    }
  }

  buyTicketWithMoney() {
    if ((this.loggedUser !== undefined)) {
      if (this.loggedUser.fidelityCard !== null) {
        let points = String(this.flightChosen.price / 10);
        this.buyTicket(parseInt(points));
      }
    } else {
      alert('Biglietto acquistato');
      this.router.navigate(['/']);
    }
  }

}


