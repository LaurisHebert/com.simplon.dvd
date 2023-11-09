import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClientRoutingModule} from './client-routing.module';
import {AdminClientListComponent} from './client-list/admin-client-list.component';
import {AdminClientEditComponent} from './client-edit/admin-client-edit.component';
import {ClientDetailComponent} from './client-detail/client-detail.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDialogModule} from "@angular/material/dialog";


@NgModule({
  declarations: [
    AdminClientListComponent,
    AdminClientEditComponent,
    ClientDetailComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule,
    MatDialogModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ClientModule {
}
