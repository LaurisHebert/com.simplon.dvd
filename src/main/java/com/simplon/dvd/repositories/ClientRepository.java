package com.simplon.dvd.repositories;

import com.simplon.dvd.entitys.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
}
