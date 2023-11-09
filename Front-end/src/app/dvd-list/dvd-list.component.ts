import {Component, OnInit} from '@angular/core';
import {Dvd} from "../interface/dvd";
import {DvdService} from "../services/dvd.service";

@Component({
  selector: 'app-dvd-list',
  templateUrl: './dvd-list.component.html',
  styleUrls: ['./dvd-list.component.css']
})
export class DvdListComponent implements OnInit {

  dvds: Dvd[] = []
  errorMessage: string = ''

  constructor(private dvdApi: DvdService) {
  }

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
}
