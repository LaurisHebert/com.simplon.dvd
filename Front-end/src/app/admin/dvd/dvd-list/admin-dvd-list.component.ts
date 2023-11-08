import {Component, OnInit} from '@angular/core';
import {Dvd} from "../../../interface/dvd";
import {DvdService} from "../../../services/dvd.service";
import {MatDialog} from "@angular/material/dialog";
import {AdminDvdEditComponent} from "../dvd-edit/admin-dvd-edit.component";

@Component({
  selector: 'app-admin-dvd-list',
  templateUrl: './admin-dvd-list.component.html',
  styleUrls: ['./admin-dvd-list.component.css']
})
export class AdminDvdListComponent implements OnInit {

  dvds: Dvd[] = []
  errorMessage: string = ''
  constructor(private dvdApi: DvdService,  private dialog: MatDialog) {}
  ngOnInit() {
    this.dvdApi.getAllDvds()
      .then(res => {
        this.dvds = res
      })
      .catch((error) => {
        console.error(error.message)
        this.errorMessage = error
      });
  }
  openEditModal(dvd: Dvd) {
    const dialogRef = this.dialog.open(AdminDvdEditComponent, {
      data: dvd
    });
    dialogRef.afterClosed().subscribe(result => {
    });
  }
  deleteDvdById ( dvd : Dvd) {
    this.dvdApi.deleteDvdById(dvd.id)
      .then(res => {
        const indexInDvds = this.dvds.findIndex(item => item.id === dvd.id);
        if (indexInDvds !== -1) {
          this.dvds.splice(indexInDvds, 1);
        }
    })
    .catch((error) => {
      console.error(error.message)
    });
  }

}
