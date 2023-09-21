package com.simplon.dvd.DTO;

public record ClientDTO (
        String clientNumber,
        String firstName,
        String lastName,
        String email,
        Integer registrationDate
){}
