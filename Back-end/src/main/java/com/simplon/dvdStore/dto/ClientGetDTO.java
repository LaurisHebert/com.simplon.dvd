package com.simplon.dvdStore.dto;

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

