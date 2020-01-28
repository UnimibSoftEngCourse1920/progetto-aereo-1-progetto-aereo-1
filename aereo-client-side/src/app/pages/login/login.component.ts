import {Component, OnInit} from '@angular/core';
import {User} from '../../class-for-entity/User';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  user: User = new User();

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  submitForm() {
    this.user.email = this.email;
    this.user.password = this.password;
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post(environment.apiUrl + '/register', this.user, {headers, observe: 'response'}).subscribe(response => {
      this.router.navigate(['/home']);
    }, err => {
      console.log('err', err);
    });


  }

}
