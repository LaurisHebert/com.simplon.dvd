package com.dvdstore.second.services;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketServiceModel {
    private Integer id;
    private BasketRepositoryModelPostgreSQL basketId;
    private Integer dvdId;
    private Integer quantity;
    private Integer price;
}
