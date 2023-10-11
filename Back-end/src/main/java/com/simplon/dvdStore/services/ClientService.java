package com.simplon.dvdStore.services;


import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Client service.
 */
@Service
public class ClientService {
    /**
     * The Repository.
     */
    @Autowired
    ClientRepository repository;

    /**
     * Save.
     *
     * @param clientServiceModel the client service model
     */
    public void save(ClientServiceModel clientServiceModel) {
        repository.save(ClientMapper.INSTANCE.serviceToRepository(clientServiceModel));
    }

    /**
     * Update.
     *
     * @param clientServiceModel the client service model
     * @param id                 the id
     */
    public void update(ClientServiceModel clientServiceModel, long id) {
        ClientRepositoryModelSQL client = ClientMapper.INSTANCE.serviceToRepository(clientServiceModel);
        client.setId(id);
        repository.save(client);
    }

    /**
     * Find by id client service model.
     *
     * @param id the id
     * @return the client service model
     */
    public ClientServiceModel findById(long id) {
        return ClientMapper.INSTANCE.repositoryToService(repository.findById(id).get());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<ClientServiceModel> findAll() {
        return ClientMapper.INSTANCE.listRepositoryToService((List<ClientRepositoryModelSQL>) repository.findAll());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(long id) {
        repository.deleteById(id);
    }


}
