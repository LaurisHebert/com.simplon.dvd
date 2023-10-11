package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Client controller.
 */
@RestController
@RequestMapping(path = "client")
public class ClientController {
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    /**
     * The Service.
     */
    @Autowired
    ClientService service;

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    /**
     * Find by id client get dto.
     *
     * @param id the id
     * @return the client get dto
     */
    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        return clientMapper.serviceToGetDTO(service.findById(id));
    }

    /**
     * Save.
     *
     * @param clientDTO the client dto
     */
    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
    }

    /**
     * Update.
     *
     * @param id        the id
     * @param clientDTO the client dto
     */
    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        service.update(clientMapper.dtoToService(clientDTO), id);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
