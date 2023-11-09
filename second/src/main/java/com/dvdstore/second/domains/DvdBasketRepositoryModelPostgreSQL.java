package com.dvdstore.second.domains;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "dvd_basket")
@NoArgsConstructor
public class DvdBasketRepositoryModelPostgreSQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_dvd")
    private int dvdId;
    @Column
    private int quantity;
    @Column
    private int price;

    @ManyToOne
    @JoinColumn(name = "id_basket")
    private BasketRepositoryModelPostgreSQL basketId;
}
