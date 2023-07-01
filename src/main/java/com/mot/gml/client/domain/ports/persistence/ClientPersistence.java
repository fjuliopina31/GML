package com.mot.gml.client.domain.ports.persistence;

import com.mot.gml.client.domain.models.client.Client;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ClientPersistence {

    Stream<Client> findAll();

    Client persist(Client client);

    Client findClientBySharedKey(String sharedKey);

    Boolean existsClientBySharedKey(String sharedKey);
}
