import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard.component';
import {DvdModule} from "./dvd/dvd.module";

const routes: Routes = [
  {path: '', component: AdminDashboardComponent,
    children:
      [
        {path: '', loadChildren: () => DvdModule},
      ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {}
