import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';

@Component({
  selector: 'app-promo',
  templateUrl: './promo.component.html',
  styleUrls: ['./promo.component.css']
})
export class PromoComponent implements OnInit {

  promoList: any = [];
  activePromoList: any = [];

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get(environment.apiUrl + '/promo')
      .subscribe(response => {
          this.promoList = response;
          this.activePromoList = this.promoList.filter(promo => promo.flight != null);
          console.log('promo', this.promoList);
          console.log('promoa', this.activePromoList);
          const promoTemp = this.promoList.filter(promo => ((promo.start < Date.now()) && (promo.end > Date.now())));
          for (let promo of promoTemp) {
            this.activePromoList.push(promo);
          }
        }, err => {
          console.log('Error: ' + err);
        }
      );
  }

}
