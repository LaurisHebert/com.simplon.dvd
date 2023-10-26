import {NgModule} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {DvdListComponent} from "./dvd-list/dvd-list.component";
import {DvdDetailComponent} from "./dvd-detail/dvd-detail.component";
import {DvdCreateComponent} from "./dvd-create/dvd-create.component";
import {DvdEditComponent} from "./dvd-edit/dvd-edit.component";


const routes: Routes = [
  {path: 'create', component: DvdCreateComponent},
  {path: 'detail', component: DvdDetailComponent},
  {path: 'edit', component: DvdEditComponent},
  {path: 'list', component: DvdListComponent},
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
