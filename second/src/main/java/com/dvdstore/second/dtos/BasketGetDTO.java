package com.dvdstore.second.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketGetDTO {
    private Integer id;
    private Integer clientId;
    private Integer totalPrice;
}
