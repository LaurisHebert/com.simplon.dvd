package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DvdRepository extends CrudRepository<DvdRepositoryModelSQL, Integer> {
    DvdRepositoryModelSQL findByIsan(String isan);

    DvdRepositoryModelSQL updateByIsan(DvdRepositoryModelSQL dvd, String isan);

    void deleteByIsan(String isan);
}
