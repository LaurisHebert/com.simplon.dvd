package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.SaleRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Sale repository.
 */
public interface SaleRepository extends CrudRepository<SaleRepositoryModelSQL, Long> {
}
