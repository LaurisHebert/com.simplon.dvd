package com.dvdstore.second.services;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasketServiceModel {
    private int id;
    private int clientId;
    private float totalPrice;
}
