package com.simplon.dvd.services;

import com.simplon.dvd.entitys.DvdEntity;
import com.simplon.dvd.repositories.DvdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DvdService {
    @Autowired
    private DvdRepository repository;

    public void save(DvdServiceModel dvdServiceModel) {
        repository.save(new DvdEntity(dvdServiceModel));
    }

    public DvdServiceModel findById(long id) {
        return new DvdServiceModel(repository.findById(id).orElseThrow());
    }

    public List<DvdServiceModel> findAll() {
        List<DvdServiceModel> dvdList = new ArrayList<>();
        for (DvdEntity dvd : repository.findAll()) {
            dvdList.add(new DvdServiceModel(dvd));
        }
        return dvdList;
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }


}
