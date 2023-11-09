package com.dvdstore.second.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "basket")
@NoArgsConstructor
public class BasketRepositoryModelPostgreSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_client")
    private Integer clientId;
    @Column(name = "total_price")
    private Integer totalPrice;

}
