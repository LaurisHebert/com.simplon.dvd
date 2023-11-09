import {Component, OnInit} from '@angular/core';
import {Client} from "../../../interface/client";
import {ClientService} from "../../../services/client.service";

@Component({
  selector: 'app-client-list',
  templateUrl: './admin-client-list.component.html',
  styleUrls: ['./admin-client-list.component.css']
})
export class AdminClientListComponent implements OnInit {

  clients: Client[] = []
  errorMessage: string = ''

  constructor(private clientApi: ClientService) {
  }

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

  deleteClientById(client: Client) {
    this.clientApi.deleteClientById(client.id)
      .then(res => {
        const indexClient = this.clients.findIndex(item => item.id === client.id);
        if (indexClient !== -1) {
          this.clients.splice(indexClient, 1);
        }
      })
      .catch((error) => {
        console.error(error.message)
      });
  }
}
