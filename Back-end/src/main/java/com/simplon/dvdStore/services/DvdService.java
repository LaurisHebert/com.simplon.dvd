package com.simplon.dvdStore.services;


import com.simplon.dvdStore.mapper.DvdMapper;
import com.simplon.dvdStore.repositories.DvdRepository;
import com.simplon.dvdStore.repositories.DvdRepositoryModelSQL;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdService {
    @Autowired
    private DvdRepository repository;

    public void save(DvdServiceModel dvdServiceModel, @Nullable Long id) {
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);
        if (id != null) dvdRepositoryModelSQL.setId(id);
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
