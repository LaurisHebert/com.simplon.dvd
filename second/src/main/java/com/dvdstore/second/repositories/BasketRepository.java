package com.dvdstore.second.repositories;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<BasketRepositoryModelPostgreSQL, Integer> {

}
