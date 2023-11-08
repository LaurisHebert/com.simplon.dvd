package com.simplon.dvdStore.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * The type Client repository model sql.
 */
@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
public class ClientRepositoryModelSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, name = "client_reference", unique = true)
    private String clientReference;
    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, name = "registration_date")
    private LocalDate registrationDate = LocalDate.now();
}

