package com.dvdstore.second.services;

import com.dvdstore.second.domains.DvdBasketRepositoryModelPostgreSQL;
import com.dvdstore.second.mappers.DvdBasketMapper;
import com.dvdstore.second.repositories.BasketRepository;
import com.dvdstore.second.repositories.DvdBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdBasketService {

    private final DvdBasketMapper dvdBasketMapper = DvdBasketMapper.INSTANCE;

    @Autowired
    private DvdBasketRepository repository;
    @Autowired
    private BasketRepository bRepository;

    public void save(DvdBasketServiceModel dvdBasketServiceModel) {
        repository.save(dvdBasketMapper.serviceToEntity(dvdBasketServiceModel));
    }

    public List<DvdBasketServiceModel> findAllByBasketId(int id) {
        return dvdBasketMapper.listRepositoryToService(repository.findAllByBasketId(bRepository.findById(id).get()));
    }

    public void update(Integer id, DvdBasketServiceModel dvdBasketServiceModel) {
        DvdBasketRepositoryModelPostgreSQL dvdBasketToUpdate = dvdBasketMapper.serviceToEntity(dvdBasketServiceModel);
        dvdBasketToUpdate.setId(id);
        repository.save(dvdBasketToUpdate);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}





