package com.simplon.dvdStore.controllers;

import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.services.ClientService;
import com.simplon.dvdStore.services.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    ClientService service;

    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
    }

    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    @GetMapping("/{clientReference}")
    public ClientGetDTO findByClientReference(@PathVariable String clientReference) {
        return clientMapper.serviceToGetDTO(service.findByClientReference(clientReference));
    }

    @PutMapping("{clientReference}")
    public ClientGetDTO updateByClientReference(@PathVariable String clientReference, @RequestBody ClientDTO clientDTO) {
        ClientServiceModel client = clientMapper.dtoToService(clientDTO);
        ClientServiceModel clientUpdated = service.updateByClientReference(client, clientReference);
        return clientMapper.serviceToGetDTO(clientUpdated);
    }

    @DeleteMapping("{clientReference}")
    public void deleteByClientReference(@PathVariable String clientReference) {
        service.deleteByClientReference(clientReference);
    }
}
