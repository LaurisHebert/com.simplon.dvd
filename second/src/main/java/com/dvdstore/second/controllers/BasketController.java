package com.dvdstore.second.controllers;

import com.dvdstore.second.dtos.BasketDTO;
import com.dvdstore.second.dtos.BasketGetDTO;
import com.dvdstore.second.dtos.DvdBasketDTO;
import com.dvdstore.second.dtos.DvdBasketGetDTO;
import com.dvdstore.second.mappers.BasketMapper;
import com.dvdstore.second.mappers.DvdBasketMapper;
import com.dvdstore.second.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "basket")
public class BasketController {
    private final BasketMapper basketMapper = BasketMapper.INSTANCE;
    private final DvdBasketMapper dvdBasketMapper = DvdBasketMapper.INSTANCE;

    @Autowired
    private BasketService basketService;

    @PostMapping()
    public void saveBasket(@RequestBody BasketDTO basketDTO) {
        basketService.saveBasket(basketMapper.basketDtoToBasketServiceModel(basketDTO));
    }

    @PostMapping("{clientId}/Basket-dvds")
    public void saveDvdBasketByClientId(@PathVariable int clientId, @RequestBody DvdBasketDTO dvdBasketDTO) {
        basketService.saveDvdBasketByClientId(clientId, dvdBasketMapper.dvdBasketDtoToDvdBasketServiceModel(dvdBasketDTO));
    }

    @GetMapping
    public List<BasketGetDTO> findAllBasket() {
        return basketMapper.listBasketServiceModelToBasketGetDto(basketService.findAllBasket());
    }

    @GetMapping("/{clientId}")
    public BasketGetDTO findBasketByClientId(@PathVariable int clientId) {
        return basketMapper.BasketServiceModelToBasketGetDto(basketService.findBasketByClientId(clientId), findAllDvdBasketByClientId(clientId));
    }

    public List<DvdBasketGetDTO> findAllDvdBasketByClientId(int clientId) {
        return dvdBasketMapper.listDvdBasketServiceModelToDvdBasketGetDto(basketService.findAllDvdBasketByClientId(clientId));
    }

    @PutMapping("/{clientId}")
    public void updateBasketByClientId(@PathVariable int clientId, @RequestBody BasketDTO basketDTO) {
        basketService.updateBasketByClientId(clientId, basketMapper.basketDtoToBasketServiceModel(basketDTO));
    }

    @PutMapping("/{clientId}/dvd-basket/{dvdBasketId}")
    public void updateDvdBasketByClientId(@PathVariable int clientId, @PathVariable int dvdBasketId, @RequestBody DvdBasketDTO dvdBasketDTO) {
        basketService.updateDvdBasketByClientId(clientId, dvdBasketId, dvdBasketMapper.dvdBasketDtoToDvdBasketServiceModel(dvdBasketDTO));
    }

    @DeleteMapping("/{clientId}")
    public void deleteBasketByClientId(@PathVariable int clientId) {
        basketService.deleteBasketByClientId(clientId);
    }

    @DeleteMapping("/{clientId}/dvd-basket/{dvdBasketId}")
    public void deleteDvdBasketByClientIdAndId(@PathVariable int clientId, @PathVariable int dvdBasketId) {
        basketService.deleteDvdBasketByClientIdAndId(clientId, dvdBasketId);
    }

    @DeleteMapping("/{clientId}/dvd-basket")
    public void deleteAllDvdBasketByClientId(@PathVariable int clientId) {
        basketService.deleteAllDvdBasketByClientId(clientId);
    }


}
