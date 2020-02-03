import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {User} from '../../class-for-entity/User';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  name: string;
  surname: string;
  email: string;
  password: string;
  repeatPassword: string;
  address: string;
  user: User = new User();

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  submitForm() {
    this.user.name = this.name;
    this.user.surname = this.surname;
    this.user.email = this.email;
    this.user.password = this.password;
    this.user.address = (this.address === null) ? '' : this.address;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post(environment.apiUrl + '/register', this.user, {headers, observe: 'response'}).subscribe( response => {
      this.router.navigate(['/home']);
    }, err => {
      console.log('err', err);
    });


  }
}
