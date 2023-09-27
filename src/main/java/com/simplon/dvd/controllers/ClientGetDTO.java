package com.simplon.dvd.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientGetDTO {
    Long id;
    String clientReference;
    String firstName;
    String lastName;
    String email;
    String registrationDate;
}

