package com.simplon.dvd.controllers;

import com.simplon.dvd.Enum.Genre;
import com.simplon.dvd.Enum.Type;

public record DvdGetDTO(
        Long id,
        String isan,
        String title,
        int releaseDate,
        String directedBy,
        int duration,
        Genre genre,
        int quantity,
        String resume,
        String filmCover,
        Type type
) {}
