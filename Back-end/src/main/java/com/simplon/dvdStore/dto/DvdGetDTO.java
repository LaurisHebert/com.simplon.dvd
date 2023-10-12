package com.simplon.dvdStore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simplon.dvdStore.enums.Genre;
import com.simplon.dvdStore.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Dvd get dto.
 */
@Data
@NoArgsConstructor
public class DvdGetDTO {
    private Integer id;
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
