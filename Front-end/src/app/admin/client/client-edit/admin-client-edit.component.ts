import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Client} from "../../../interface/client";
import {ClientService} from "../../../services/client.service";

@Component({
  selector: 'app-client-edit',
  templateUrl: './admin-client-edit.component.html',
  styleUrls: ['./admin-client-edit.component.css']
})
export class AdminClientEditComponent implements OnInit {
  client: Client = {
    id: 0,
    clientReference: "",
    firstName: "",
    lastName: "",
    email: "",
    favoriteGenre: "ACTION",
    registrationDate: new Date()
  }

  constructor(@Inject(MAT_DIALOG_DATA) public data: Client, private clientApi: ClientService, private dialogRef: MatDialogRef<AdminClientEditComponent>) {
  }

  ngOnInit() {
    if (this.data) {
      this.client = this.data
    }
  }

  updateRegistrationDate(event: any) {
    this.client.registrationDate = new Date(event.target.value);
  }


  sendClient() {
    if (this.client.id > 0) {
      this.updateClient()
    } else {
      this.creatClient()
    }
  }

  creatClient() {
    this.clientApi.createClient(this.client).then(res => {
      this.dialogRef.close()
    })
      .catch((error) => {
        console.error(error.message)
      });
  }

  updateClient() {
    this.clientApi.updateClient(this.client).then(res => {
      this.dialogRef.close()
    })
      .catch((error) => {
        console.error(error.message)
      });
  }

}
