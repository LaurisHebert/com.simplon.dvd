package com.simplon.dvdStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Client get dto.
 */
@Data
@NoArgsConstructor
public class ClientGetDTO {
    /**
     * The Id.
     */
    Long id;
    /**
     * The Client reference.
     */
    String clientReference;
    /**
     * The First name.
     */
    String firstName;
    /**
     * The Last name.
     */
    String lastName;
    /**
     * The Email.
     */
    String email;
    /**
     * The Registration date.
     */
    String registrationDate;
}

