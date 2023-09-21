package com.simplon.dvd.services;

import com.simplon.dvd.DTO.ClientDTO;
import com.simplon.dvd.entitys.ClientEntity;
import com.simplon.dvd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public void save(ClientServiceModel client) {
        repository.save(new ClientEntity(client));
    }

    public ClientServiceModel findById(long id) {
        return new ClientServiceModel(repository.findById(id).orElseThrow());
    }

    public List<ClientServiceModel> findAll() {
        List<ClientServiceModel> clients = new ArrayList<>();

        for (ClientEntity client : repository.findAll() ) {
            clients.add(new ClientServiceModel(client));
        }

        return clients;
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
