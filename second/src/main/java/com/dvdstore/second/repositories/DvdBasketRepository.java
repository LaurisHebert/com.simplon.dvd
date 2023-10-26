package com.dvdstore.second.repositories;

import com.dvdstore.second.domains.BasketRepositoryModelPostgreSQL;
import com.dvdstore.second.domains.DvdBasketRepositoryModelPostgreSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DvdBasketRepository extends CrudRepository<DvdBasketRepositoryModelPostgreSQL, Integer> {

    List<DvdBasketRepositoryModelPostgreSQL> findAllByBasketId(BasketRepositoryModelPostgreSQL basketRepositoryModelPostgreSQL);
    void deleteAllByBasketId(BasketRepositoryModelPostgreSQL basketRepositoryModelPostgreSQL);

}
