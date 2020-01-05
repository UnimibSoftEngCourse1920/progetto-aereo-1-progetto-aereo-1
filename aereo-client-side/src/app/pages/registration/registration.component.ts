import {Component, OnInit} from '@angular/core';

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

  constructor() {
  }

  ngOnInit() {
  }

  submitForm() {
  }

}
