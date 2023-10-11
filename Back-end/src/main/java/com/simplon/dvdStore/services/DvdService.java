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
    public void save(DvdServiceModel dvdServiceModel) {
        repository.save(DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel));
    }

    /**
     * Update.
     *
     * @param dvdServiceModel the dvd service model
     * @param id              the id
     */
    public void update(DvdServiceModel dvdServiceModel, long id) {
        DvdRepositoryModelSQL dvdRepositoryModelSQL = DvdMapper.INSTANCE.dvdServiceToDvdEntity(dvdServiceModel);
        dvdRepositoryModelSQL.setId(id);
        repository.save(dvdRepositoryModelSQL);
    }

    /**
     * Find by id dvd service model.
     *
     * @param id the id
     * @return the dvd service model
     */
    public DvdServiceModel findById(long id) {
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
    public void deleteById(long id) {
        repository.deleteById(id);
    }


}
