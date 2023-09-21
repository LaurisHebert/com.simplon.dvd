package com.simplon.dvd.controllers;

import com.simplon.dvd.DTO.ClientDTO;
import com.simplon.dvd.DTO.ClientGetDTO;
import com.simplon.dvd.services.ClientService;
import com.simplon.dvd.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    @Autowired
    ClientService service;

    @PostMapping
    public void save(@RequestBody ClientDTO client) {
        service.save(new ClientServiceModel(client));
    }

    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        ClientServiceModel client = service.findById(id);
        return new ClientGetDTO(client);
    }

    @GetMapping
    public List<ClientGetDTO> findAll() {
        List<ClientGetDTO> clients = new ArrayList<>();

        for (ClientServiceModel client : service.findAll()) {
            clients.add(new ClientGetDTO(client));
        }
        return clients;
    }

    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO client) {
        service.save(new ClientServiceModel(id, client));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
