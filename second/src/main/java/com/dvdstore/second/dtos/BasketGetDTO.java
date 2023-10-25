package com.dvdstore.second.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BasketGetDTO {
    private int id;
    private int clientId;
    private float totalPrice;
    private List<DvdBasketGetDTO> dvds;
}
