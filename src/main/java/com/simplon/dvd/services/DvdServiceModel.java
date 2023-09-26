package com.simplon.dvd.services;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private int releaseDate;
    private Genre genre;
    private Type type;
}
