package com.simplon.dvdStore.services;

import com.simplon.dvdStore.Enum.Genre;
import com.simplon.dvdStore.Enum.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class DvdServiceModel {
    private long id;
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
