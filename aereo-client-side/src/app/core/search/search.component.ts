import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  departureLocation: string;
  landingLocation: string;
  departureDay: string;
  constructor(private http: HttpClient, private router: Router) {
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
