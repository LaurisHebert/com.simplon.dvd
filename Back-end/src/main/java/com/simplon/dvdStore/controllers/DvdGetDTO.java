package com.simplon.dvdStore.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simplon.dvdStore.Enum.Genre;
import com.simplon.dvdStore.Enum.Type;
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
