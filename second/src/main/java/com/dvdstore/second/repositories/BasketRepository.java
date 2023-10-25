package com.dvdstore.second.repositories;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends CrudRepository<BasketRepositoryModelPostgreSQL, Integer> {
    Optional<BasketRepositoryModelPostgreSQL> findByClientId(Integer clientId);

    void deleteByClientId(Integer clientId);
}
