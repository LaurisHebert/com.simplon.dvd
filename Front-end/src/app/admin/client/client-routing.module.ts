import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {AdminDashboardComponent} from "../admin-dashboard.component";
import {DvdModule} from "../dvd/dvd.module";
import {ClientModule} from "./client.module";
import {AdminDvdListComponent} from "../dvd/dvd-list/admin-dvd-list.component";
import {AdminClientListComponent} from "./client-list/admin-client-list.component";

const routes: Routes = [
  {path: 'list', component: AdminClientListComponent },
  {path: '', redirectTo: 'list', pathMatch: 'full'}
]

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [RouterModule],
})
export class ClientRoutingModule { }
