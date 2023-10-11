package com.simplon.dvdStore.services;

import com.simplon.dvdStore.domain.SaleRepositoryModelSQL;
import com.simplon.dvdStore.mapper.SaleMapper;
import com.simplon.dvdStore.repositories.ClientRepository;
import com.simplon.dvdStore.repositories.DvdRepository;
import com.simplon.dvdStore.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Sale service.
 */
@Service
public class SaleService {
    private final SaleMapper saleMapper = SaleMapper.INSTANCE;
    /**
     * The Dvd repository.
     */
    @Autowired
    DvdRepository dvdRepository;
    /**
     * The Client repository.
     */
    @Autowired
    ClientRepository clientRepository;
    /**
     * The Sale repository.
     */
    @Autowired
    SaleRepository saleRepository;

    /**
     * Save.
     *
     * @param saleServiceModel the sale service model
     */
    public void save(SaleServiceModel saleServiceModel) {
        saleRepository.save(saleMapper.serviceToRepository(clientRepository.findById(saleServiceModel.getClient_id()).get(), dvdRepository.findById(saleServiceModel.getDvd_id()).get(), saleServiceModel.getQuantity()));
    }

    /**
     * Update.
     *
     * @param saleServiceModel the sale service model
     * @param id               the id
     */
    public void update(SaleServiceModel saleServiceModel, long id) {
        saleRepository.save(saleMapper.serviceToRepositoryUpdate(id, clientRepository.findById(saleServiceModel.getClient_id()).get(), dvdRepository.findById(saleServiceModel.getDvd_id()).get(), saleServiceModel.getQuantity()));
    }

    /**
     * Find by id sale service model.
     *
     * @param id the id
     * @return the sale service model
     */
    public SaleServiceModel findById(long id) {
        return SaleMapper.INSTANCE.repositoryToService(saleRepository.findById(id).get());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<SaleServiceModel> findAll() {
        return SaleMapper.INSTANCE.listRepositoryToService((List<SaleRepositoryModelSQL>) saleRepository.findAll());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(long id) {
        saleRepository.deleteById(id);
    }


}
