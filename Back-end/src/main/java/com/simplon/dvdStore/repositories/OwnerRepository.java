package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.OwnerRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<OwnerRepositoryModelSQL, Integer> {
    OwnerRepositoryModelSQL findByLogin(String login);
}
