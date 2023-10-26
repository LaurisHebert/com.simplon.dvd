import { NgModule } from '@angular/core';
import { AdminDashboardComponent } from './admin-dashboard.component';
import { AdminRoutingModule } from './admin-routing.module';
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [AdminDashboardComponent],
  imports: [
    AdminRoutingModule,
    CommonModule
  ],
  bootstrap: [AdminDashboardComponent]
})
export class AdminModule {}
