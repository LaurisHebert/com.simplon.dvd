package com.simplon.dvd.DTO;

import com.simplon.dvd.services.ClientServiceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ClientGetDTO {
    Long id;
    String clientNumber; // clientId ? clientTag ? trouver un nom
    String firstName;
    String lastName;
    String email;
    Integer registrationDate;

    public ClientGetDTO(ClientServiceModel client) {
        this.id = client.getId();
        this.clientNumber = client.getClientNumber();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.registrationDate = client.getRegistrationDate();
    }
}

