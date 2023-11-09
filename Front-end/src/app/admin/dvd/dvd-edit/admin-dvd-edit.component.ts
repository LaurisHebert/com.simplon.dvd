import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Dvd} from "../../../interface/dvd";
import {DvdService} from "../../../services/dvd.service";

@Component({
  selector: 'app-dvd-edit',
  templateUrl: './admin-dvd-edit.component.html',
  styleUrls: ['./admin-dvd-edit.component.css']
})
export class AdminDvdEditComponent implements OnInit {
  dvd: Dvd = {
    id: 0,
    directedBy: "",
    duration: 0,
    filmCover: "",
    genre: "ACTION",
    isan: "",
    quantity: 0,
    releaseDate: new Date(),
    resume: "",
    title: "",
    type: "MOVIE"
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data: Dvd, private dvdApi: DvdService, private dialogRef : MatDialogRef<AdminDvdEditComponent>) {
  }

  ngOnInit() {
    if (this.data) {
      this.dvd = this.data
    }
  }

  sendDvd() {
    if (this.dvd.id >0) {
      this.updateDvd()
    } else {
      this.creatDvd()
    }
  }

  creatDvd() {
    this.dvdApi.createDvd(this.dvd).then(res => {
      this.dialogRef.close()
    })
      .catch((error) => {
        console.error(error.message)
      });
  }

  updateDvd() {
    this.dvdApi.updateDvd(this.dvd).then(res => {
      this.dialogRef.close()
    })
      .catch((error) => {
        console.error(error.message)
      });
  }
}
