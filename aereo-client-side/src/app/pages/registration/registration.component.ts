import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Router} from '@angular/router';
import {User} from '../../class-for-entity/User';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  name: string;
  surname: string;
  dateOfBirth: string;
  email: string;
  password: string;
  repeatPassword: string;
  address: string;
  lastDate: string;
  fedeltaPunti: bigint;
  // aggiungere Data creazione account/ultimo acquisto e punti fedeltà

  constructor(private http: HttpClient, private router: Router) {
  }

  ngOnInit() {
  }

  test1() {
    this.http.get(environment.apiUrl + '/test').subscribe(response => {
        alert('res ' + response);
      }
    );
  }

  submitForm() {

    const user: User = new User();
    user.name = this.name;
    user.surname = this.surname;
    user.dateOfBirth = this.dateOfBirth;
    user.email = this.email;
    user.password = this.password;
    user.address = this.address;

    const headers: HttpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.post(environment.apiUrl + '/user', user, {
      headers,
      observe: 'response',
      withCredentials: true
    }).subscribe(response => {
        alert('Registrazione avvenuta con successo!');
        setTimeout(() => {
          this.router.navigate(['/home']);
        }, 3000);
      },
      err => {
        alert(err.error);
      });
  }
}
