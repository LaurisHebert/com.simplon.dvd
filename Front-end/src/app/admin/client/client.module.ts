import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ClientRoutingModule} from './client-routing.module';
import {AdminClientListComponent} from './client-list/admin-client-list.component';
import {ClientCreateComponent} from './client-create/client-create.component';
import {ClientEditComponent} from './client-edit/client-edit.component';
import {ClientDetailComponent} from './client-detail/client-detail.component';


@NgModule({
  declarations: [
    AdminClientListComponent,
    ClientCreateComponent,
    ClientEditComponent,
    ClientDetailComponent
  ],
  imports: [
    CommonModule,
    ClientRoutingModule
  ]
})
export class ClientModule {
}
