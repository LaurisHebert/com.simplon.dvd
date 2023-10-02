import { Injectable } from '@angular/core';
import {Dvd} from "../../interface/dvd";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class DvdService {

  constructor() { }
  private apiUrl = "http://localhost:8080/dvd";
  getAllDvds = async () => {
    try {
      const response = await axios.get(this.apiUrl)

      const dvds: Dvd[] = response.data.map((data: any) => ({
        directedBy: data.directedBy,
        duration: data.duration,
        filmCover: data.filmCover,
        genre: data.genre,
        isan: data.isan,
        quantity: data.quantity,
        releaseDate: data.releaseDate,
        resume: data.resume,
        title: data.title,
        type: data.type
      }))

      return dvds

    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération des DVDs : ' + error);
    }
  }
}
