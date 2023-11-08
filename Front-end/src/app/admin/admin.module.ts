import { NgModule } from '@angular/core';
import { AdminDashboardComponent } from './admin-dashboard.component';
import { AdminRoutingModule } from './admin-routing.module';
import {CommonModule} from "@angular/common";
import {IonicModule} from "@ionic/angular";

@NgModule({
  declarations: [AdminDashboardComponent],
    imports: [
        AdminRoutingModule,
        CommonModule,
        IonicModule
    ],
  bootstrap: [AdminDashboardComponent]
})
export class AdminModule {}
