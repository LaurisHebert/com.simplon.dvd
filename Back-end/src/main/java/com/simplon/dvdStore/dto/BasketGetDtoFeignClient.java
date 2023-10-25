package com.simplon.dvdStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BasketGetDtoFeignClient {
    private Integer id;
    private Integer clientId;
    private Integer totalPrice;
    private List<DvdBasketGetDtoFeignClient> dvds;
}
