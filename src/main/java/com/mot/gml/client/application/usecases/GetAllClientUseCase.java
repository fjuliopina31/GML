package com.mot.gml.client.application.usecases;

import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class GetAllClientUseCase {

    private ClientPersistence clientPersistence;

    private static Logger log = LogManager.getLogger(GetAllClientUseCase.class);

    public Stream<Client> handle(){
        String methodSignature = "Initialization method handle in GetAllClientUseCase";
        log.debug(methodSignature);
        log.info(AppGMLConstants.PROCESSING_USE_CASE +"GetAllClientUseCase");
        return clientPersistence.findAll();
    }
}
