package com.simplon.dvd.services;

import com.simplon.dvd.mapper.ClientMapper;
import com.simplon.dvd.repositories.ClientRepository;
import com.simplon.dvd.repositories.ClientRepositoryModelSQL;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public void save(ClientServiceModel clientServiceModel, @Nullable Long id) {
        ClientRepositoryModelSQL client = ClientMapper.INSTANCE.serviceToRepository(clientServiceModel);
        if (id != null) client.setId(id);
        repository.save(client);
    }

    public ClientServiceModel findById(long id) {
        return ClientMapper.INSTANCE.repositoryToService(repository.findById(id).get());
    }

    public List<ClientServiceModel> findAll() {
        return ClientMapper.INSTANCE.listRepositoryToService((List<ClientRepositoryModelSQL>) repository.findAll());
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
