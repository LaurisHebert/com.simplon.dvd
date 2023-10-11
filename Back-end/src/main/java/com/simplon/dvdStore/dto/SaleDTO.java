package com.simplon.dvdStore.dto;

/**
 * The type Sale dto.
 */
public record SaleDTO(
        long client,
        long dvd,
        int quantity
) {
}


