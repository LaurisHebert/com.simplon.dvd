package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.*;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Client controller.
 */
@RestController
@RequestMapping(path = "clients")
public class ClientController {


    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    ClientService service;

    @PostMapping
    public boolean saveClient(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
        return true;
    }

    @PostMapping("{clientId}/basket/basket-dvds")
    public void saveDvdBasketByClientId(@PathVariable("clientId") int clientId, @RequestBody DvdBasketDtoFeignClient dvdBasket) {
        service.saveDvdBasketByClientId(clientId, dvdBasket);
    }

    @GetMapping("/{clientId}")
    public ClientGetDTO findClientById(@PathVariable int clientId) {
        return clientMapper.serviceToGetDTO(service.findById(clientId));
    }

    @GetMapping("{clientId}/basket")
    public BasketGetDtoFeignClient findBasketByClientId(@PathVariable("clientId") int clientId) {
        return service.findBasketByClientId(clientId);
    }

    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    @GetMapping("basket")
    List<BasketGetDtoFeignClient> findAllBasket() {
        return service.findAllBasket();
    }

    @PutMapping("{clientId}")
    public void updateClient(@PathVariable int clientId, @RequestBody ClientDTO clientDTO) {
        service.update(clientMapper.dtoToService(clientDTO), clientId);
    }

    @PutMapping("/{clientId}/basket")
    void updateBasketByClientId(@PathVariable("clientId") int clientId, @RequestBody BasketDtoFeignClient basketDto) {
        service.updateBasketByClientId(clientId, basketDto);
    }

    @PutMapping("/{clientId}/basket/dvd-basket/{dvdBasketId}")
    void updateDvdBasketByClientId(@PathVariable("clientId") int clientId, @PathVariable("dvdBasketId") int dvdBasketId, @RequestBody DvdBasketDtoFeignClient dvdBasket) {
        service.updateDvdBasketByClientId(clientId, dvdBasketId, dvdBasket);
    }

    @DeleteMapping("{clientId}")
    public void deleteClientById(@PathVariable int clientId) {
        service.deleteById(clientId);
        service.deleteBasketByClientId(clientId);
    }

    @DeleteMapping("/{clientId}/basket/dvd-basket/{dvdBasketId}")
    void deleteDvdBasketByClientIdAndId(@PathVariable("clientId") int clientId, @PathVariable("dvdBasketId") int dvdBasketId) {
        service.deleteDvdBasketByClientIdAndId(clientId, dvdBasketId);
    }

    @DeleteMapping("/{clientId}/basket/dvd-basket")
    void deleteAllDvdBasketByClientId(@PathVariable("clientId") int clientId) {
        service.deleteAllDvdBasketByClientId(clientId);
    }
}
