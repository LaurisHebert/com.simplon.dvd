package com.dvdstore.second.services;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.domains.DvdBasketRepositoryModelPostgreSQL;
import com.dvdstore.second.mappers.BasketMapper;
import com.dvdstore.second.mappers.DvdBasketMapper;
import com.dvdstore.second.repositories.BasketRepository;
import com.dvdstore.second.repositories.DvdBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    private final BasketMapper basketMapper = BasketMapper.INSTANCE;
    private final DvdBasketMapper dvdBasketMapper = DvdBasketMapper.INSTANCE;

    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private DvdBasketRepository dvdBasketRepository;

    public void saveBasket(BasketServiceModel basketServiceModel) {
        basketRepository.save(basketMapper.BasketServiceModelToBasketRepositoryModelPostgreSQL(basketServiceModel));
    }

    public void saveDvdBasketByClientId(int clientId, DvdBasketServiceModel dvdBasketServiceModel) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            dvdBasketRepository.save(dvdBasketMapper.dvdBasketServiceModelToDvdBasketRepositoryModelPostgreSQL(dvdBasketServiceModel, basketRepository.findByClientId(clientId).get()));
        } else {
            System.out.println("basket does not exist");
        }
    }

    public List<BasketServiceModel> findAllBasket() {
        return basketMapper.listBasketRepositoryModelPostgreSQLToBasketServiceModel(basketRepository.findAll());
    }

    public BasketServiceModel findBasketByClientId(int clientId) {
        return basketMapper.BasketRepositoryModelPostgreSQLToBasketServiceModel(basketRepository.findByClientId(clientId).orElse(null));
    }

    public List<DvdBasketServiceModel> findAllDvdBasketByClientId(int clientId) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            return dvdBasketMapper.listDvdBasketRepositoryModelPostgreSQLToDvdServiceModel(dvdBasketRepository.findAllByBasketId(basketRepository.findByClientId(clientId).get()));
        }
        return null;
    }

    public void updateBasketByClientId(int clientId, BasketServiceModel basketServiceModel) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            BasketRepositoryModelPostgreSQL oldBasket = basketRepository.findByClientId(clientId).get();
            BasketRepositoryModelPostgreSQL newBasket = basketMapper.BasketServiceModelToBasketRepositoryModelPostgreSQL(basketServiceModel);
            newBasket.setId(oldBasket.getId());
            basketRepository.save(newBasket);
        } else {
            System.out.println("basket does not exist");
        }
    }

    public void updateDvdBasketByClientId(int clientId, int dvdBasketId, DvdBasketServiceModel dvdBasketServiceModel) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            BasketRepositoryModelPostgreSQL basket = basketRepository.findByClientId(clientId).get();

            if (dvdBasketRepository.findById(dvdBasketId).isPresent()) {

                DvdBasketRepositoryModelPostgreSQL oldDvdBasket = dvdBasketRepository.findById(dvdBasketId).get();
                DvdBasketRepositoryModelPostgreSQL newDvdBasket = dvdBasketMapper.dvdBasketServiceModelToDvdBasketRepositoryModelPostgreSQL(dvdBasketServiceModel, basket);

                newDvdBasket.setId(oldDvdBasket.getId());

                dvdBasketRepository.save(newDvdBasket);
            }

        } else {
            System.out.println("basket does not exist");
        }
    }

    public void deleteBasketByClientId(int clientId) {
        basketRepository.deleteByClientId(clientId);
        deleteAllDvdBasketByClientId(clientId);
    }

    public void deleteDvdBasketByClientIdAndId(int clientId, int dvdBasketId) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            dvdBasketRepository.deleteById(dvdBasketId);
        }
    }

    public void deleteAllDvdBasketByClientId(int clientId) {
        if (basketRepository.findByClientId(clientId).isPresent()) {
            dvdBasketRepository.deleteAllByBasketId(basketRepository.findByClientId(clientId).get());
        }
    }
}
