package com.mot.gml.client.infrastructure.persistence.postgres;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.infrastructure.adapters.persistence.DAOS.ClientRepository;
import com.mot.gml.client.infrastructure.adapters.persistence.entities.ClientEntity;
import com.mot.gml.client.infrastructure.adapters.persistence.postgres.ClientPersistencePostgres;
import com.mot.gml.client.infrastructure.transversal.mappers.IClientMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClientPersistencePostgresTest {

    @Mock
    ClientRepository clientRepository;
    @Mock
    private IClientMapper clientMapper;

    @InjectMocks
    private ClientPersistencePostgres clientPersistencePostgres;

    private ClientEntity clientEntity;

    private List<ClientEntity> clientEntities;

    private Stream<Client> clients;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clientEntity = new ClientEntity();
        clientEntity.setId(11);
        clientEntity.setSharedKey("fjulio31");
        clientEntity.setName("Fabio Julio");
        clientEntity.setEmail("fjulio.pina30@gmail.com");
        clientEntity.setPhone("3042416725");
        clientEntity.setStartDate(new Date());
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        clientEntities  = List.of(clientEntity);
        clients = Stream.of(client);
    }

    @Test
    void findAll() {
        when(clientRepository.save(clientEntity)).thenReturn(clientEntity);
        when(clientRepository.findAll()).thenReturn(clientEntities);
        when(clientMapper.clientToClientEntity(client)).thenReturn(clientEntities.get(0));
        System.out.println(clientPersistencePostgres.persist(client));
        System.out.println("getSharedKey:"+client.getSharedKey());
        Stream<Client> clientsResponse = clientPersistencePostgres.findAll();
        assertNotNull(clientPersistencePostgres.persist(client));
        System.out.println("clientResponse:"+clientsResponse);
    }

    @Test
    void findClientBySharedKey() {
        when(clientRepository.save(clientEntity)).thenReturn(clientEntity);
        when(clientRepository.findBySharedKey(clientEntity.getSharedKey())).thenReturn(clientEntity);
        when(clientMapper.clientToClientEntity(client)).thenReturn(clientEntity);
        System.out.println(clientPersistencePostgres.persist(client));
        System.out.println("getSharedKey:"+client.getSharedKey());
        Client clientResponse = clientPersistencePostgres.findClientBySharedKey(client.getSharedKey());
        assertNotNull(clientPersistencePostgres.persist(client));
        System.out.println("clientResponse:"+clientResponse);
    }

    @Test
    void findClientBySharedKeyExists() {
        when(clientRepository.save(clientEntity)).thenReturn(clientEntity);
        when(clientRepository.findBySharedKey(clientEntity.getSharedKey())).thenReturn(clientEntity);
        when(clientMapper.clientToClientEntity(client)).thenReturn(clientEntity);
        System.out.println(clientPersistencePostgres.persist(client));
        System.out.println("getSharedKey:"+client.getSharedKey());
        Boolean response = clientPersistencePostgres.existsClientBySharedKey(client.getSharedKey());
        assertNotNull(clientPersistencePostgres.persist(client));
        System.out.println("exists:"+response);
    }

    @Test
    void persist() {
        when(clientRepository.save(clientEntity)).thenReturn(clientEntity);
        when(clientMapper.clientToClientEntity(client)).thenReturn(clientEntity);
        Client clientResponse = clientPersistencePostgres.persist(client);
        assertNotNull(clientPersistencePostgres.persist(client));
        assertEquals(client,clientResponse);
    }
}