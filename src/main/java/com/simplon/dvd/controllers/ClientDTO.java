package com.simplon.dvd.controllers;

public record ClientDTO(
        String clientReference,
        String firstName,
        String lastName,
        String email
) {
}
