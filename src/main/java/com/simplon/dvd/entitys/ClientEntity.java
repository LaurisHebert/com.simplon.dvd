package com.simplon.dvd.entitys;

import com.simplon.dvd.services.ClientServiceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name = "client_number")
    private String clientNumber; // clientId ? clientTag ? trouver un nom
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, name = "registration_date")
    private Integer registrationDate;

    public ClientEntity(ClientServiceModel client) {
        this.id = client.getId();
        this.clientNumber = client.getClientNumber();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.registrationDate = client.getRegistrationDate();
    }
}

