package com.simplon.dvdStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BasketGetDtoFeignClient {
    private int id;
    private int clientId;
    private int totalPrice;
    private List<DvdBasketGetDtoFeignClient> dvds;
}
