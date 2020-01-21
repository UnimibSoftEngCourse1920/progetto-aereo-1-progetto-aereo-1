import {Component, OnInit, PipeTransform, Pipe} from '@angular/core';


import {FlightList} from './flight'; // Importa classe voli


@Component({
  selector: 'app-flight-list',
  templateUrl: './flight-list.component.html',
  styleUrls: ['./flight-list.component.css']
})
export class FlightListComponent implements OnInit {

  data = [ // Test data
    {
      id: '2783',
      posti: 18,
      LP: 'Milano',
      LA: 'Mosca',
      DP: '08/09/2011', // non ho trovato format Data
      OP: '09:30',
      state: true, // false = Effettuato/cancellato, quindi non mostra in lista
    },
    {
      id: '1880',
      posti: 2,
      LP: 'Tokyo',
      LA: 'New York',
      DP: '11/09/2011', // non ho trovato format Data
      OP: '20:30',
      state: true, // false = Effettuato/cancellato, quindi non mostra in lista
    },
    {
      id: '2827',
      posti: 12,
      LP: 'New York',
      LA: 'Milano',
      DP: '15/07/2011', // non ho trovato format Data
      OP: '6:00',
      state: false, // false = Effettuato/cancellato, quindi non mostra in lista
    }
  ];

  constructor() {
  }

  ngOnInit() {
  }

}
