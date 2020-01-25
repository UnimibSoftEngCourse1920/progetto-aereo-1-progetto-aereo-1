import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import {RouterModule} from '@angular/router';
import { SearchComponent } from './search/search.component';



@NgModule({
    declarations: [HeaderComponent, FooterComponent, SearchComponent],
  exports: [
    HeaderComponent,
    FooterComponent,
    SearchComponent
  ],
    imports: [
        CommonModule,
        RouterModule
    ]
})
export class CoreModule { }
