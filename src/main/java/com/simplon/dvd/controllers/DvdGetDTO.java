package com.simplon.dvd.controllers;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdGetDTO {
    private Long id;
    private String isan;
    private String title;
    private String directedBy;
    private int duration;
    private int quantity;
    private String resume;
    private String filmCover;
    private int releaseDate;
    private Type type;
    private Genre genre;
}
