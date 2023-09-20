package com.simplon.dvd.repositories;

import com.simplon.dvd.entitys.DvdEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DvdRepository extends CrudRepository<DvdEntity, Long> {

}
