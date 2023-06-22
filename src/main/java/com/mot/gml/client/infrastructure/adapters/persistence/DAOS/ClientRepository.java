package com.mot.gml.client.infrastructure.adapters.persistence.DAOS;

import com.mot.gml.client.infrastructure.adapters.persistence.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

    List<ClientEntity> findAll();

    ClientEntity findBySharedKey(String sharedKey);

    ClientEntity save(ClientEntity client);


}
