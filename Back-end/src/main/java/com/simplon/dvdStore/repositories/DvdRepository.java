package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.DvdRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Dvd repository.
 */
public interface DvdRepository extends CrudRepository<DvdRepositoryModelSQL, Integer> {
}
