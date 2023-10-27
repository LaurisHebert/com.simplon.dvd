import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {DvdDetailComponent} from "../../dvd-detail/dvd-detail.component";
import {AdminDvdCreateComponent} from "./dvd-create/admin-dvd-create.component";
import {AdminDvdEditComponent} from "./dvd-edit/admin-dvd-edit.component";
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
