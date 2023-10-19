package com.dvdstore.second.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketServiceModel {
    private Integer id;
    private Integer clientId;
    private Float totalPrice;
}
