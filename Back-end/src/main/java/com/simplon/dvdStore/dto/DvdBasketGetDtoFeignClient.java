package com.simplon.dvdStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketGetDtoFeignClient {
    private int id;
    private int dvdId;
    private int quantity;
    private int price;
}
