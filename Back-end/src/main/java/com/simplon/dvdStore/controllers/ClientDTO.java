package com.simplon.dvdStore.controllers;

public record ClientDTO(
        String clientReference,
        String firstName,
        String lastName,
        String email
) {
}
