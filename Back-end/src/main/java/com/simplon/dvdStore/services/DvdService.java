package com.simplon.dvdStore.services;


import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Dvd service.
 */
@Service
public class DvdService {
    private final DvdMapper dvdMapper = DvdMapper.INSTANCE;

    @Autowired
    private DvdRepository repository;

    public void save(DvdServiceModel dvdServiceModel) {
        repository.save(dvdMapper.serviceToRepository(dvdServiceModel));
    }

    public List<DvdServiceModel> findAll() {
        return dvdMapper.listRepositoryToService((List<DvdRepositoryModelSQL>) repository.findAll());
    }

    public DvdServiceModel findByIsan(String isan) {
        return dvdMapper.repositoryToService(repository.findByIsan(isan));
    }

    public DvdServiceModel updateByIsan(DvdServiceModel dvdServiceModel, String isan) {
        DvdRepositoryModelSQL dvd = dvdMapper.serviceToRepository(dvdServiceModel);
        DvdRepositoryModelSQL dvdUpdated = repository.updateByIsan(dvd,isan);
        return dvdMapper.repositoryToService(dvdUpdated);
    }

    public void deleteByIsan(String isan) {
        repository.deleteByIsan(isan);
    }
}
