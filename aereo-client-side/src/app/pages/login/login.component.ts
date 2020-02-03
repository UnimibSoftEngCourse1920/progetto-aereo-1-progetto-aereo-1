import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  submitForm() {
    this.http.get('/user/' + this.email + '/' + this.password).subscribe(response => {
      console.log('response', response);
      if (response != null) {
        // sessionStorage.setItem('loggedUserId', response.id);
      }
    });


  }

}
