package com.simplon.dvd.controllers;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import com.simplon.dvd.services.DvdServiceModel;

public class DvdGetDTO {
    Long id = null;
    String isan;
    String title;
    int releaseDate;
    String directedBy;
    int duration;
    Genre genre;
    int quantity;
    String resume;
    String filmCover;
    Type type;

    public DvdGetDTO (DvdServiceModel dvd) {
        this.id = dvd.getId();
        this.isan = dvd.getIsan();
        this.title = dvd.getTitle();
        this.releaseDate = dvd.getReleaseDate();
        this.directedBy = dvd.getDirectedBy();
        this.duration = dvd.getDuration();
        this.genre = dvd.getGenre();
        this.quantity = dvd.getQuantity();
        this.resume = dvd.getResume();
        this.filmCover = dvd.getFilmCover();
        this.type = dvd.getType();
    }
}
