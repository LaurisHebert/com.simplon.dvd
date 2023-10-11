package com.simplon.dvdStore.services;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Client service model.
 */
@Data
@NoArgsConstructor
public class ClientServiceModel {
    private Long id;
    private String clientReference;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registrationDate;
}
