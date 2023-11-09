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
    @Autowired
    private DvdRepository repository;

    /**
     * Save.
     *
     * @param dvdServiceModel the dvd service model
     */
    public boolean save(DvdServiceModel dvdServiceModel) {
        repository.save(DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel));
        return true;
    }

    /**
     * Update.
     *
     * @param dvdServiceModel the dvd service model
     * @param id              the id
     */
    public boolean update(DvdServiceModel dvdServiceModel, int id) {
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);
        dvdRepositoryModelSQL.setId(id);
        repository.save(dvdRepositoryModelSQL);
        return true;
    }

    /**
     * Find by id dvd service model.
     *
     * @param id the id
     * @return the dvd service model
     */
    public DvdServiceModel findById(int id) {
        if (repository.findById(id).isPresent())
            return DvdMapper.INSTANCE.dvdEntityToDvdService(repository.findById(id).get());
        else return null;
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<DvdServiceModel> findAll() {
        return DvdMapper.INSTANCE.listDvdEntityToDvdService((List<DvdRepositoryModelSQL>) repository.findAll());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }


}
