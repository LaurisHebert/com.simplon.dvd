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
    private Integer id;
    @Column(name = "id_dvd")
    private Integer dvdId;
    @Column
    private Integer quantity;
    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "id_basket")
    private BasketRepositoryModelPostgreSQL basketId;
}
