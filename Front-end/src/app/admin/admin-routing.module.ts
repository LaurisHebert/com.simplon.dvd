import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminDashboardComponent} from './admin-dashboard.component';
import {DvdModule} from "./dvd/dvd.module";
import {ClientModule} from "./client/client.module";

const routes: Routes = [
  {
    path: '', component: AdminDashboardComponent,
    children:
      [
        {path: 'dvds', loadChildren: () => DvdModule},
        {path: 'clients', loadChildren: () => ClientModule},
        {path: '', redirectTo: 'clients', pathMatch: 'full'}

      ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
