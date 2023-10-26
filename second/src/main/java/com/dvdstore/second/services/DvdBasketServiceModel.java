package com.dvdstore.second.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketServiceModel {
    private int id;
    private int dvdId;
    private int quantity;
    private int price;
}
