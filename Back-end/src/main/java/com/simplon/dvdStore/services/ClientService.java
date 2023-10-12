package com.simplon.dvdStore.services;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    final ClientMapper clientMapper = ClientMapper.INSTANCE;

    @Autowired
    ClientRepository repository;

    public void save(ClientServiceModel clientServiceModel) {
        repository.save(clientMapper.serviceToRepository(clientServiceModel));
    }

    public List<ClientServiceModel> findAll() {
        return clientMapper.listRepositoryToService((List<ClientRepositoryModelSQL>) repository.findAll());
    }

    public ClientServiceModel findByClientReference(String clientReference) {
        return clientMapper.repositoryToService(repository.findByClientReference(clientReference));
    }

    public ClientServiceModel updateByClientReference(ClientServiceModel clientServiceModel, String clientReference) {
        ClientRepositoryModelSQL client = clientMapper.serviceToRepository(clientServiceModel);
        ClientRepositoryModelSQL clientUpdated = repository.updateByClientReference(client, clientReference);
        return clientMapper.repositoryToService(clientUpdated);
    }

    public void deleteByClientReference(String clientReference) {
        repository.deleteByClientReference(clientReference);
    }


}
