package com.simplon.dvd.controllers;

public record DvdDTO (
        String isan,
        String title,
        int releaseDate,
        String directedBy,
        int duration,
        int quantity,
        String resume,
        String filmCover,
        String type,
        String genre
) {}
