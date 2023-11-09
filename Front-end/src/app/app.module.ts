import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {CommonModule} from "@angular/common";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {DvdListComponent} from "./dvd-list/dvd-list.component";
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {IonicModule} from '@ionic/angular';

@NgModule({
  declarations: [
    DvdListComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    NgbModule,
    BrowserAnimationsModule,
    IonicModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
