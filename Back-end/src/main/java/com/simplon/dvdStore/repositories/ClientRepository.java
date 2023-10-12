package com.simplon.dvdStore.repositories;

import com.simplon.dvdStore.domain.ClientRepositoryModelSQL;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientRepositoryModelSQL, Integer> {
    ClientRepositoryModelSQL findByClientReference(String clientReference);

    ClientRepositoryModelSQL updateByClientReference(ClientRepositoryModelSQL client, String clientReference);

    void deleteByClientReference(String clientReference);
}
