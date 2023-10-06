package com.simplon.dvdStore.dto;

public record DvdDTO(
        String isan,
        String title,
        String releaseDate,
        String directedBy,
        int duration,
        int quantity,
        String resume,
        String filmCover,
        String type,
        String genre
) {
}
