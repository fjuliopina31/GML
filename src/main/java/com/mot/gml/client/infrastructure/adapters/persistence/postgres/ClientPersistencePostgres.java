package com.mot.gml.client.infrastructure.adapters.persistence.postgres;

import com.mot.gml.client.domain.exceptions.BusinessException;
import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import com.mot.gml.client.infrastructure.adapters.persistence.DAOS.ClientRepository;
import com.mot.gml.client.infrastructure.adapters.persistence.entities.ClientEntity;
import com.mot.gml.client.infrastructure.transversal.mappers.IClientMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class ClientPersistencePostgres implements ClientPersistence {

    private static Logger log = LogManager.getLogger(ClientPersistencePostgres.class);


    @Autowired
    ClientRepository clientRepository;

    @Autowired
    IClientMapper clientMapper;

    @Override
    public Stream<Client> findAll() {
        String methodSignature = "Initialization method find All";
        log.debug(methodSignature);
        List<ClientEntity> clientEntities;
        if(this.clientRepository.findAll() != null){
            clientEntities = this.clientRepository.findAll();
            return clientEntities.stream().map(ClientEntity::toClient);
        }
        return null;
    }

    @Override
    public Client persist(Client client) {
        String methodSignature = "Initialization method persist";
        log.debug(methodSignature);
        ClientEntity clientEntity = this.clientMapper.clientToClientEntity(client);
        this.clientRepository.save(clientEntity);
        return client;
    }

    @Override
    public Client findClientBySharedKey(String sharedKey) {
        String methodSignature = "Initialization method findClientBySharedKey in ClientPersistencePostgres";
        log.debug(methodSignature);
        log.info("Find client with parameter shared key:["+sharedKey+"]");
        ClientEntity clientEntity = this.clientRepository.findBySharedKey(sharedKey);
        if(clientEntity != null){
            log.debug("client found");
            return this.clientMapper.clientEntityToClient(clientEntity);
        }
        throw new BusinessException("B-304", sharedKey, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Boolean existsClientBySharedKey(String sharedKey) {
        String methodSignature = "Initialization method findClientBySharedKey in ClientPersistencePostgres";
        log.debug(methodSignature);
        log.info("Find client with parameter shared key:["+sharedKey+"]");
        ClientEntity clientEntity = this.clientRepository.findBySharedKey(sharedKey);
        return clientEntity != null;
    }
}
