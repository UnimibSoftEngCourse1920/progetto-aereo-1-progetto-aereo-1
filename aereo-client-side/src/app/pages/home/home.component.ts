import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  departureLocation: string;
  landingLocation: string;
  departureDay: string;
  flightList: any = [];

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  submitSearch() {
    this.http.get(environment.apiUrl + '/flights/ ' + this.landingLocation + '/' + this.departureDay + '/' + this.departureLocation)
      .subscribe(response => {
        this.flightList = response;
      }
    );
  }

}
