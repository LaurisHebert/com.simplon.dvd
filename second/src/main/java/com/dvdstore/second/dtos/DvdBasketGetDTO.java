package com.dvdstore.second.dtos;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.repositories.BasketRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketGetDTO {
    private Integer id;
    private Integer dvdId;
    private Integer quantity;
    private Integer price;
}
