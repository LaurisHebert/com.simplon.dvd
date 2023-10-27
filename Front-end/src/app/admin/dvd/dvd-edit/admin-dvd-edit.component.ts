import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {Dvd} from "../../../interface/dvd";
import {DvdService} from "../../../services/dvd.service";

@Component({
  selector: 'app-dvd-edit',
  templateUrl: './admin-dvd-edit.component.html',
  styleUrls: ['./admin-dvd-edit.component.css']
})
export class AdminDvdEditComponent implements OnInit {
constructor(@Inject(MAT_DIALOG_DATA) public data: Dvd, private dvdApi: DvdService) {}
  dvd: Dvd= {
    id : 0,
    directedBy : "",
    duration : 0,
    filmCover : "",
    genre : "",
    isan : "",
    quantity : 0,
    releaseDate: new Date(),
    resume : "",
    title : "",
    type : ""
  }
  ngOnInit() {
    this.dvd = this.data
  }
  updateDvd() {
    this.dvdApi.updateDvd(this.dvd).then(res => {
      console.log("lala")
    })
      .catch((error) => {
        console.error(error.message)
      });
  }
}
