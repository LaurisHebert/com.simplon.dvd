package com.dvdstore.second.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketGetDTO {
    private int id;
    private int dvdId;
    private int quantity;
    private float price;
}
