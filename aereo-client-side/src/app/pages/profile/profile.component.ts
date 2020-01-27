import { Component, OnInit } from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any;
  ticketsList: any = [];
  constructor(private http: HttpClient) { }

  ngOnInit() {
    // to retrieve logged user data
    this.http.get(environment.apiUrl + '/user/' + sessionStorage.getItem('loggedUserId'))
      .subscribe(response => {
          this.user = response;
          this.ticketsList = this.user.tickets;
        }, err => {
          alert('Error: ' + err);
        }
      );
  }
}
