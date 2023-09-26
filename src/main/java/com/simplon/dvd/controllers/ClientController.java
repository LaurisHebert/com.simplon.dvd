package com.simplon.dvd.controllers;


import com.simplon.dvd.mapper.ClientMapper;
import com.simplon.dvd.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    ClientService service;

    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(ClientMapper.INSTANCE.dtoToService(clientDTO), null);
    }

    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        return ClientMapper.INSTANCE.serviceToGetDTO(service.findById(id));
    }

    @GetMapping
    public List<ClientGetDTO> findAll() {
        return ClientMapper.INSTANCE.listServiceToGetDTO(service.findAll());
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        service.save(ClientMapper.INSTANCE.dtoToService(clientDTO), id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
