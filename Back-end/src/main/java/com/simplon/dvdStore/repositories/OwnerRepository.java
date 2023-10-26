package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.OwnerRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Owner repository.
 */
@Repository
public interface OwnerRepository extends CrudRepository<OwnerRepositoryModelSQL, Integer> {
    /**
     * Find by login owner repository model sql.
     *
     * @param login the login
     * @return the owner repository model sql
     */
    OwnerRepositoryModelSQL findByLogin(String login);
}
