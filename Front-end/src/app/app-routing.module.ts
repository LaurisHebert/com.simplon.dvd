import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminModule} from "./admin/admin.module";
import {DvdListComponent} from "./dvd-list/dvd-list.component";
import {DvdDetailComponent} from "./dvd-detail/dvd-detail.component";

const routes: Routes = [
  {path: 'admin', loadChildren: () => AdminModule},
  {path: 'dvds', component: DvdListComponent},
  {path: 'dvd/:id', component: DvdDetailComponent},
  {path: '', redirectTo: 'admin', pathMatch: 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
