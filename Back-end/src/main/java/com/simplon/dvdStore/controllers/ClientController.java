package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.BasketGetDtoFeignClient;
import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
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

    @Autowired
    BasketFeignClientRepository basket;

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    ClientService service;
    // CLIENTS \\
    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }
    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        return clientMapper.serviceToGetDTO(service.findById(id));
    }
    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
    }
    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {service.update(clientMapper.dtoToService(clientDTO), id);}
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }

    // BASKET \\
    @GetMapping("{id}/basket")
    public BasketGetDtoFeignClient findBasketByClientId(@PathVariable("id") int clientId) {
        return basket.findBasketByClientId(clientId);
    }
}
