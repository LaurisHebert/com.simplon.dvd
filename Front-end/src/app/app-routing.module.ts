import { NgModule } from '@angular/core';
import { Routes, RouterModule} from '@angular/router';
import {AdminModule} from "./admin/admin.module";
import {AppComponent} from "./app.component";

const routes: Routes = [
  {path: 'admin', loadChildren: () => AdminModule},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
