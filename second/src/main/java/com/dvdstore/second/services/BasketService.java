package com.dvdstore.second.services;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.mappers.BasketMapper;
import com.dvdstore.second.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private final BasketMapper basketMapper = BasketMapper.INSTANCE;

    @Autowired
    private BasketRepository repository;

    public void save(BasketServiceModel basketServiceModel) {
        repository.save(basketMapper.serviceToRepository(basketServiceModel));
    }

    public List<BasketServiceModel> findAll() {
        return basketMapper.listRepositoryToService(repository.findAll());
    }
    public BasketServiceModel findById(Integer id) {
        return basketMapper.repositoryToService(repository.findById(id).get());
    }
    public void update(Integer id, BasketServiceModel basketServiceModel) {
        BasketRepositoryModelPostgreSQL basketToUpdate = basketMapper.serviceToRepository(basketServiceModel);
        basketToUpdate.setId(id);
        repository.save(basketToUpdate);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
