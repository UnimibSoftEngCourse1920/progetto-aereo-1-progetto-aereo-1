import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  departureLocation: string;
  landingLocation: string;
  departureDay: string;
  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  submitSearch() {
    sessionStorage.setItem('departureLocation', this.departureLocation);
    sessionStorage.setItem('landingLocation', this.landingLocation);
    sessionStorage.setItem('departureDay', this.departureDay);
    this.router.navigate(['/flight-list']);
  }

}
