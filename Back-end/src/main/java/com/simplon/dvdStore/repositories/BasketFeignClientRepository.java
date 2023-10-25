package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.dto.BasketDtoFeignClient;
import com.simplon.dvdStore.dto.BasketGetDtoFeignClient;
import com.simplon.dvdStore.dto.DvdBasketDtoFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "basket", url = "http://localhost:8081/basket")
public interface BasketFeignClientRepository {

    @PostMapping()
    void saveBasket(@RequestBody BasketFeignClientRepository basket);
    @PostMapping("{clientId}/Basket-dvds")
    void saveDvdBasketByClientId(@PathVariable("clientId") int clientId,
                                 @RequestBody DvdBasketDtoFeignClient dvdBasket);
    @GetMapping
    List<BasketGetDtoFeignClient> findAllBasket();
    @GetMapping("/{clientId}")
    BasketGetDtoFeignClient findBasketByClientId(@PathVariable("clientId") int clientId);
    @PutMapping("/{clientId}")
    void updateBasketByClientId(@PathVariable("clientId") int clientId,
                                @RequestBody BasketDtoFeignClient basket);
    @PutMapping("/{clientId}/dvd-basket/{dvdBasketId}")
    void updateDvdBasketByClientId(@PathVariable("clientId") int clientId,
                                   @PathVariable("dvdBasketId") int dvdBasketId,
                                   @RequestBody DvdBasketDtoFeignClient dvdBasket);
    @DeleteMapping("/{clientId}")
    void deleteBasketByClientId(@PathVariable("clientId") int clientId);

    @DeleteMapping("/{clientId}/dvd-basket/{dvdBasketId}")
    void deleteDvdBasketByClientIdAndId(@PathVariable("clientId") int clientId,
                                        @PathVariable("dvdBasketId") int dvdBasketId);

    @DeleteMapping("/{clientId}/dvd-basket")
    void deleteAllDvdBasketByClientId(@PathVariable("clientId") int clientId);
}
