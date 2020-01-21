import { Component, OnInit } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  id: string;
  user: any;
  ticketsList: any = [];
  constructor(private http: HttpClient) { }

  ngOnInit() {
    // to retrieve logged user data
    this.http.get(environment.apiUrl + '/user/' + this.id)
      .subscribe(response => {
          this.user = response;
        }, err => {
          alert('Error: ' + err);
        }
      );

    // to retrieve all tickets of the logged user
    this.http.get(environment.apiUrl + '/tickets/' + this.id)
      .subscribe(response => {
          this.ticketsList = response;
        }, err => {
          alert('Error: ' + err);
        }
      );
  }

}
