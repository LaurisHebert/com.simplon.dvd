package com.simplon.dvdStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DvdBasketGetDtoFeignClient {
    private Integer id;
    private Integer dvdId;
    private Integer quantity;
    private Integer price;
}
