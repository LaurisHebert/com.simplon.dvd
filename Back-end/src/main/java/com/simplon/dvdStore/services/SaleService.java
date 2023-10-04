package com.simplon.dvdStore.services;

import com.simplon.dvdStore.mapper.SaleMapper;
import com.simplon.dvdStore.repositories.ClientRepository;
import com.simplon.dvdStore.repositories.DvdRepository;
import com.simplon.dvdStore.repositories.SaleRepository;
import com.simplon.dvdStore.repositories.SaleRepositoryModelSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleMapper saleMapper = SaleMapper.INSTANCE;
    @Autowired
    DvdRepository dvdRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    SaleRepository saleRepository;

    public void save(SaleServiceModel saleServiceModel) {
        saleRepository.save(saleMapper.serviceToRepository(clientRepository.findById(saleServiceModel.getClient_id()).get(), dvdRepository.findById(saleServiceModel.getDvd_id()).get(), saleServiceModel.getQuantity()));
    }

    public void update(SaleServiceModel saleServiceModel, long id) {
        saleRepository.save(saleMapper.serviceToRepositoryUpdate(id,clientRepository.findById(saleServiceModel.getClient_id()).get(), dvdRepository.findById(saleServiceModel.getDvd_id()).get(), saleServiceModel.getQuantity()));
    }

    public SaleServiceModel findById(long id) {
        return SaleMapper.INSTANCE.repositoryToService(saleRepository.findById(id).get());
    }

    public List<SaleServiceModel> findAll() {
        return SaleMapper.INSTANCE.listRepositoryToService((List<SaleRepositoryModelSQL>) saleRepository.findAll());
    }

    public void deleteById(long id) {
        saleRepository.deleteById(id);
    }


}
