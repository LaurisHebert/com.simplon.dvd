package com.simplon.dvdStore.services;


import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdService {
    @Autowired
    private DvdRepository repository;

    public void save(DvdServiceModel dvdServiceModel) {
        repository.save(DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel));
    }

    public void update(DvdServiceModel dvdServiceModel, long id) {
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);
        dvdRepositoryModelSQL.setId(id);
        repository.save(dvdRepositoryModelSQL);
    }

    public DvdServiceModel findById(long id) {
        if (repository.findById(id).isPresent())
            return DvdMapper.INSTANCE.dvdEntityToDvdService(repository.findById(id).get());
        else return null;
    }

    public List<DvdServiceModel> findAll() {
        return DvdMapper.INSTANCE.listDvdEntityToDvdService((List<DvdRepositoryModelSQL>) repository.findAll());
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }


}
