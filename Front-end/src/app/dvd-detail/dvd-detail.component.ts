import {Component} from '@angular/core';
import {Dvd} from "../interface/dvd";
import {DvdService} from "../services/dvd.service";

@Component({
  selector: 'app-dvd-detail',
  templateUrl: './dvd-detail.component.html',
  styleUrls: ['./dvd-detail.component.css']
})
export class DvdDetailComponent {

  dvd: Dvd = {
    id: 0,
    directedBy: "",
    duration: 0,
    filmCover: "",
    genre: "",
    isan: "",
    quantity: 0,
    releaseDate: new Date(),
    resume: "",
    title: "",
    type: ""
  }
  errorMessage: string = ''

  constructor(private dvdApi: DvdService) {
  }

  ngOnInit() {
    this.dvdApi.getDvdById(1)
      .then(res => {
        this.dvd = res
      })
      .catch((error) => {
        console.error(error.message)
        this.errorMessage = error
      });
  }
}
