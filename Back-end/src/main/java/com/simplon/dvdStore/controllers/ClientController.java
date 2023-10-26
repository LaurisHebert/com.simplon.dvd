package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.*;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.repositories.BasketFeignClientRepository;
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
    @Autowired
    BasketFeignClientRepository basket;

    @PostMapping
    public void saveClient(@RequestBody ClientDTO clientDTO) {
        ClientGetDTO client = clientMapper.serviceToGetDTO(service.save(clientMapper.dtoToService(clientDTO)));
        basket.saveBasket(new BasketDtoFeignClient(client.getId()));
    }

    @PostMapping("{clientId}/basket/basket-dvds")
    public void saveDvdBasketByClientId(@PathVariable("clientId") int clientId, @RequestBody DvdBasketDtoFeignClient dvdBasket) {
        basket.saveDvdBasketByClientId(clientId, dvdBasket);
    }

    @GetMapping("/{clientId}")
    public ClientGetDTO findClientById(@PathVariable int clientId) {
        return clientMapper.serviceToGetDTO(service.findById(clientId));
    }

    @GetMapping("{clientId}/basket")
    public BasketGetDtoFeignClient findBasketByClientId(@PathVariable("clientId") int clientId) {
        return basket.findBasketByClientId(clientId);
    }

    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    @GetMapping("basket")
    List<BasketGetDtoFeignClient> findAllBasket() {
        return basket.findAllBasket();
    }

    @PutMapping("{clientId}")
    public void updateClient(@PathVariable int clientId, @RequestBody ClientDTO clientDTO) {
        service.update(clientMapper.dtoToService(clientDTO), clientId);
    }

    @PutMapping("/{clientId}/basket")
    void updateBasketByClientId(@PathVariable("clientId") int clientId, @RequestBody BasketDtoFeignClient basketDto) {
        basket.updateBasketByClientId(clientId, basketDto);
    }

    @PutMapping("/{clientId}/basket/dvd-basket/{dvdBasketId}")
    void updateDvdBasketByClientId(@PathVariable("clientId") int clientId, @PathVariable("dvdBasketId") int dvdBasketId, @RequestBody DvdBasketDtoFeignClient dvdBasket) {
        basket.updateDvdBasketByClientId(clientId, dvdBasketId, dvdBasket);
    }

    @DeleteMapping("{clientId}")
    public void deleteClientById(@PathVariable int clientId) {
        service.deleteById(clientId);
        basket.deleteBasketByClientId(clientId);
    }

    @DeleteMapping("/{clientId}/basket/dvd-basket/{dvdBasketId}")
    void deleteDvdBasketByClientIdAndId(@PathVariable("clientId") int clientId, @PathVariable("dvdBasketId") int dvdBasketId) {
        basket.deleteDvdBasketByClientIdAndId(clientId, dvdBasketId);
    }

    @DeleteMapping("/{clientId}/basket/dvd-basket")
    void deleteAllDvdBasketByClientId(@PathVariable("clientId") int clientId) {
        basket.deleteAllDvdBasketByClientId(clientId);
    }
}
