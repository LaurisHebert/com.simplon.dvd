import {Injectable} from '@angular/core';
import axios from "axios";
import {Client} from "../interface/client";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private apiUrl = "http://localhost:8080/clients";

  constructor() {
  }

  getAllClients = async () => {
    try {
      const response = await axios.get(this.apiUrl)

      const clients: Client[] = response.data.map((data: any) => ({
        id: data.id,
        clientReference: data.clientReference,
        firstName: data.firstName,
        lastName: data.lastName,
        favoriteGenre: "ACTION",
        email: data.email,
        registrationDate: new Date(data.registrationDate),
      }))

      return clients

    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération des Clients : ' + error);
    }
  }


  getDvdById = async (id: number) => {
    try {
      const response = await axios.get(this.apiUrl + "/" + id)
      const client: Client = response.data
      return client

    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération du DVD : ' + error);
    }
  }

  createClient = async (client: Client) => {
    try {
      const response = await axios.post(this.apiUrl, client)
      return response.data
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la création du Client : ' + error);
    }
  }
  updateClient = async (client: Client) => {
    try {
      const response = await axios.put(this.apiUrl + "/" + client.id, client)
      return response.data
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la mise à jour du Client : ' + error);
    }
  }

  deleteClientById = async (id: number) => {
    try {
      const response = await axios.delete(this.apiUrl + "/" + id)
      return response.data
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la suppression du Client : ' + error);
    }
  }

}
