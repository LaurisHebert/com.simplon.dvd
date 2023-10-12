package com.simplon.dvdStore.dto;

/**
 * The type Dvd dto.
 */
public record DvdDTO(
        String isan,
        String title,
        String releaseDate,
        String directedBy,
        Integer duration,
        Integer quantity,
        String resume,
        String filmCover,
        String type,
        String genre
) {
}
