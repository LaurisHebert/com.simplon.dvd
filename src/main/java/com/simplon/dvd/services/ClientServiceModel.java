package com.simplon.dvd.services;

import com.simplon.dvd.DTO.ClientDTO;
import com.simplon.dvd.entitys.ClientEntity;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ClientServiceModel {
    private Long id;
    private String clientNumber;
    private String firstName;
    private String lastName;
    private String email;
    private Integer registrationDate;

    public ClientServiceModel(ClientEntity client) {
        this.id = client.getId();
        this.clientNumber = client.getClientNumber();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.registrationDate = client.getRegistrationDate();
    }

    public ClientServiceModel(ClientDTO client) {
        this.clientNumber = client.clientNumber();
        this.firstName = client.firstName();
        this.lastName = client.lastName();
        this.email = client.email();
        this.registrationDate = client.registrationDate();
    }
    public ClientServiceModel(long id, ClientDTO client) {
        this.id = id;
        this.clientNumber = client.clientNumber();
        this.firstName = client.firstName();
        this.lastName = client.lastName();
        this.email = client.email();
        this.registrationDate = client.registrationDate();
    }
}
