import {Component, OnInit} from '@angular/core';
import { MatDialog } from "@angular/material/dialog";
import { Client } from "../../../interface/client";
import {ClientService} from "../../../services/client.service";
@Component({
  selector: 'app-client-list',
  templateUrl: './admin-client-list.component.html',
  styleUrls: ['./admin-client-list.component.css']
})
export class AdminClientListComponent implements OnInit {

  clients: Client[] = []
  errorMessage: string = ''
  constructor(private clientApi: ClientService) {}
  ngOnInit() {
    this.clientApi.getAllClients()
      .then(res => {
        this.clients = res
      })
      .catch((error) => {
        console.error(error.message)
        this.errorMessage = error
      });
  }
}
