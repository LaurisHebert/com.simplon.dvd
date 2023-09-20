package com.simplon.dvd.services;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import com.simplon.dvd.controllers.DvdDTO;
import com.simplon.dvd.controllers.DvdGetDTO;
import com.simplon.dvd.entitys.DvdEntity;
import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdServiceModel {
    private Long id = null;
    private String isan;
    private String title;
    private int releaseDate;
    private String directedBy;
    private int duration;
    private Genre genre;
    private int quantity;
    private String resume;
    private String filmCover;
    private Type type;

    public DvdServiceModel(DvdEntity dvd) {
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
    public DvdServiceModel(DvdDTO dvd) {
        this.isan = dvd.isan();
        this.title = dvd.title();
        this.releaseDate = dvd.releaseDate();
        this.directedBy = dvd.directedBy();
        this.duration = dvd.duration();
        this.genre = dvd.genre();
        this.quantity = dvd.quantity();
        this.resume = dvd.resume();
        this.filmCover = dvd.filmCover();
        this.type = dvd.type();
    }
}
