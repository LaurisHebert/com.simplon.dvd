package com.simplon.dvdStore.services;


import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.repositories.ClientRepository;
import com.simplon.dvdStore.repositories.ClientRepositoryModelSQL;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public void save(ClientServiceModel clientServiceModel) {
        repository.save(ClientMapper.INSTANCE.serviceToRepository(clientServiceModel));
    }
    public void update(ClientServiceModel clientServiceModel, long id) {
        ClientRepositoryModelSQL client = ClientMapper.INSTANCE.serviceToRepository(clientServiceModel);
        client.setId(id);
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
