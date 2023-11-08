import { Injectable } from '@angular/core';
import {Dvd} from "../interface/dvd";
import {DvdToSent} from "../interface/dvdToSent";
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class DvdService {

  constructor() { }
  private apiUrl = "http://localhost:8080/dvds";
  getAllDvds = async () => {
    try {
      const response = await axios.get(this.apiUrl)

      const dvds: Dvd[] = response.data.map((data: any) => ({
        id : data.id,
        directedBy: data.directedBy,
        duration: data.duration,
        filmCover: data.filmCover,
        genre: data.genre,
        isan: data.isan,
        quantity: data.quantity,
        releaseDate: new Date (data.releaseDate),
        resume: data.resume,
        title: data.title,
        type: data.type
      }))

      return dvds

    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération des DVDs : ' + error);
    }
  }

  getDvdById = async (id: number) => {
    try {
      const response = await axios.get(this.apiUrl+"/"+id)
      const dvd: Dvd = response.data
      return dvd

    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la récupération du DVD : ' + error);
    }
  }

  updateDvd = async (dvd: Dvd) => {
    try {
    const dvdToSent : DvdToSent = {
        id: dvd.id,
        directedBy: dvd.directedBy,
        duration: dvd.duration,
        filmCover: dvd.filmCover,
        genre: dvd.genre,
        isan: dvd.isan,
        quantity: dvd.quantity,
        releaseDate: dvd.releaseDate.toLocaleDateString('fr-FR', { day: '2-digit', month: '2-digit', year: 'numeric' }),
        resume: dvd.resume,
        title: dvd.title,
        type: dvd.type
      }

      const response = await axios.put(this.apiUrl+"/"+dvd.id, dvdToSent)
      return response.data
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la mise à jour du DVD : ' + error);
    }
  }

  deleteDvdById = async (id: number) => {
    try {
      const response = await axios.delete(this.apiUrl+"/"+id)
      return response.data
    } catch (error) {
      throw new Error('Une erreur s\'est produite lors de la suppression du DVD : ' + error);
    }
  }
}
