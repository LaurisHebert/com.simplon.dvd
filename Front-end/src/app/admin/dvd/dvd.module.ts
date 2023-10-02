import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DvdListComponent } from './dvd-list/dvd-list.component';
import { DvdCreateComponent } from './dvd-create/dvd-create.component';
import { DvdDetailComponent } from './dvd-detail/dvd-detail.component';
import { DvdEditComponent } from './dvd-edit/dvd-edit.component';
import { DvdRoutingModule } from './dvd-routing.module';



@NgModule({
  declarations: [
    DvdListComponent,
    DvdCreateComponent,
    DvdDetailComponent,
    DvdEditComponent
  ],
  imports: [
    CommonModule,
    DvdRoutingModule
  ],
})
export class DvdModule { }
