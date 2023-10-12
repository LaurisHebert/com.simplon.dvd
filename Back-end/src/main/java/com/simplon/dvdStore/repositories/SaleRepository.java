package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.SaleRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<SaleRepositoryModelSQL, Integer> {
}
