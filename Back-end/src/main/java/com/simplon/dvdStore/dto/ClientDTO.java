package com.simplon.dvdStore.dto;

/**
 * The type Client dto.
 */
public record ClientDTO(
        String clientReference,
        String firstName,
        String lastName,
        String email
) {
}
