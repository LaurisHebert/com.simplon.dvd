import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {AdminDvdListComponent} from "./dvd-list/admin-dvd-list.component";


const routes: Routes = [
  {path: 'list', component: AdminDvdListComponent},
  {path: '', redirectTo: 'list', pathMatch: 'full'}
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
})
export class DvdRoutingModule {
}
