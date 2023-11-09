import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DvdDetailComponent} from '../../dvd-detail/dvd-detail.component';
import {AdminDvdEditComponent} from './dvd-edit/admin-dvd-edit.component';
import {DvdRoutingModule} from './dvd-routing.module';
import {AdminDvdListComponent} from "./dvd-list/admin-dvd-list.component";
import {MatDialogModule} from '@angular/material/dialog';
import {FormsModule} from "@angular/forms";
import {IonicModule} from "@ionic/angular";


@NgModule({
  declarations: [
    DvdDetailComponent,
    AdminDvdEditComponent,
    AdminDvdListComponent
  ],
  imports: [
    CommonModule,
    MatDialogModule,
    DvdRoutingModule,
    FormsModule,
    IonicModule,
  ],
})
export class DvdModule {
}
