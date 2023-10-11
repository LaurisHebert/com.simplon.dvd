package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Client repository.
 */
public interface ClientRepository extends CrudRepository<ClientRepositoryModelSQL, Long> {
}
