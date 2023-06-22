package com.mot.gml.client.application.usecases;

import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.domain.exceptions.BusinessException;
import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateClientUseCase {

    private ClientPersistence clientPersistence;
    private static Logger log = LogManager.getLogger(CreateClientUseCase.class);

    public Client handle(Client client)throws Exception {
        String methodSignature = "Initialization method handle in CreateClientUseCase";
        log.debug(methodSignature);
        log.info(AppGMLConstants.PROCESSING_USE_CASE +"CreateClientUseCase");
        if(!clientPersistence.existsClientBySharedKey(client.getSharedKey())){
            return clientPersistence.persist(client);
        }
        throw new BusinessException("R-405", client.getSharedKey(), HttpStatus.BAD_REQUEST);
    }
}
