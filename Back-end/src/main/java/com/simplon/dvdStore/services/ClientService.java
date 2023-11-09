package com.simplon.dvdStore.services;


import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import com.simplon.dvdStore.dto.BasketDtoFeignClient;
import com.simplon.dvdStore.dto.BasketGetDtoFeignClient;
import com.simplon.dvdStore.dto.DvdBasketDtoFeignClient;
import com.simplon.dvdStore.mapper.ClientMapper;
import com.simplon.dvdStore.repositories.BasketFeignClientRepository;
import com.simplon.dvdStore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Client service.
 */
@Service
public class ClientService {
    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    /**
     * The Repository.
     */
    @Autowired
    ClientRepository repository;
      @Autowired
      BasketFeignClientRepository basket;

    /**
     * Save.
     *
     * @param clientServiceModel the client service model
     */
    public void save(ClientServiceModel clientServiceModel) {
        ClientRepositoryModelSQL client = repository.save(clientMapper.serviceToRepository(clientServiceModel));
        basket.saveBasket(new BasketDtoFeignClient(client.getId()));
    }

    /**
     * Update.
     *
     * @param clientServiceModel the client service model
     * @param id                 the id
     */
    public void update(ClientServiceModel clientServiceModel, int id) {
        ClientRepositoryModelSQL client = clientMapper.serviceToRepository(clientServiceModel);
        client.setId(id);
        repository.save(client);
    }

    /**
     * Find by id client service model.
     *
     * @param id the id
     * @return the client service model
     */
    public ClientServiceModel findById(int id) {
        return clientMapper.repositoryToService(repository.findById(id).get());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<ClientServiceModel> findAll() {
        return clientMapper.listRepositoryToService((List<ClientRepositoryModelSQL>) repository.findAll());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(int id) {
        repository.deleteById(id);
    }


    public void updateBasketByClientId(int clientId, BasketDtoFeignClient basketDto) {
        basket.updateBasketByClientId(clientId, basketDto);
    }

    public void updateDvdBasketByClientId(int clientId, int dvdBasketId, DvdBasketDtoFeignClient dvdBasket) {
        basket.updateDvdBasketByClientId(clientId, dvdBasketId, dvdBasket);
    }

    public void deleteBasketByClientId(int clientId) {
        basket.deleteBasketByClientId(clientId);
    }

    public void deleteDvdBasketByClientIdAndId(int clientId, int dvdBasketId) {
        basket.deleteDvdBasketByClientIdAndId(clientId, dvdBasketId);
    }

    public void deleteAllDvdBasketByClientId(int clientId) {
        basket.deleteAllDvdBasketByClientId(clientId);
    }

    public List<BasketGetDtoFeignClient> findAllBasket() {
        return basket.findAllBasket();
    }

    public void saveDvdBasketByClientId(int clientId, DvdBasketDtoFeignClient dvdBasket) {
        basket.saveDvdBasketByClientId(clientId, dvdBasket);
    }

    public BasketGetDtoFeignClient findBasketByClientId(int clientId) {
        return basket.findBasketByClientId(clientId);
    }
}
