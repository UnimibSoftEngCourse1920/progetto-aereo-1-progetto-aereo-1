import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  departureLocation: string = 'all';
  landingLocation: string = 'all';
  departureDay: string = 'any';

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  submitSearch() {
    if ((this.departureLocation === this.landingLocation) && (this.departureLocation !== 'all')) {
      alert('Attenzione luogo di partenza e arrivo coincidono!');
      return;
    } else {
      sessionStorage.setItem('departureLocation', this.departureLocation);
      sessionStorage.setItem('landingLocation', this.landingLocation);
      sessionStorage.setItem('departureDay', this.departureDay);
      this.router.navigate(['/flight-list']);
    }
  }
}
