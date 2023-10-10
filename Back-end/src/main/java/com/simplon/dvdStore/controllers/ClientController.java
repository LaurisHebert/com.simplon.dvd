package com.simplon.dvdStore.controllers;


import com.simplon.dvdStore.dto.ClientDTO;
import com.simplon.dvdStore.dto.ClientGetDTO;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.services.ClientService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "client")
@PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
public class ClientController {
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    @Autowired
    ClientService service;

    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    @GetMapping
    public List<ClientGetDTO> findAll() {
        return clientMapper.listServiceToGetDTO(service.findAll());
    }

    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    @PostMapping
    public void save(@RequestBody ClientDTO clientDTO) {
        service.save(clientMapper.dtoToService(clientDTO));
    }

    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable long id) {
        return clientMapper.serviceToGetDTO(service.findById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    @PutMapping("{id}")
    public void update(@PathVariable long id, @RequestBody ClientDTO clientDTO) {
        service.update(clientMapper.dtoToService(clientDTO), id);
    }

    @PreAuthorize("hasAuthority('ADMIN_ROLE')")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
