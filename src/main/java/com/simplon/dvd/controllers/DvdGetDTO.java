package com.simplon.dvd.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate releaseDate;
    private Type type;
    private Genre genre;
}
