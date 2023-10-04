package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    ClientService service;

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
    }

    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        return clientMapper.serviceToGetDTO(service.findById(id));
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        service.update(clientMapper.dtoToService(clientDTO), id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
