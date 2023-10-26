package com.simplon.dvdStore.services;

import com.simplon.dvdStore.enums.Genre;
import com.simplon.dvdStore.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Dvd service model.
 */
@Data
@NoArgsConstructor
public class DvdServiceModel {
    private int id;
    private String isan;
    private String title;
    private String directedBy;
    private int duration;
    private int quantity;
    private String resume;
    private String filmCover;
    private LocalDate releaseDate;
    private Genre genre;
    private Type type;
}
