import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminClientListComponent} from "./client-list/admin-client-list.component";

const routes: Routes = [
  {path: 'list', component: AdminClientListComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
})
export class ClientRoutingModule {
}
