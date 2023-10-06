package com.simplon.dvdStore.dto;

public record ClientDTO(
        String clientReference,
        String firstName,
        String lastName,
        String email
) {
}
