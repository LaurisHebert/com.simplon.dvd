package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.SaleRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;

public interface SaleRepository extends CrudRepository<SaleRepositoryModelSQL, Long> {
}
