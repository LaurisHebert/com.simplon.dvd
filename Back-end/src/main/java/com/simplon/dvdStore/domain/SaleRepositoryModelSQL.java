package com.simplon.dvdStore.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Sale repository model sql.
 */
@Entity
@Data
@Table(name = "sale")
@NoArgsConstructor
public class SaleRepositoryModelSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientRepositoryModelSQL client;
    @ManyToOne
    @JoinColumn(name = "dvd_id")
    private DvdRepositoryModelSQL dvd;

}
