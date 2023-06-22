package com.mot.gml.client.application.usecases;

import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetClientUseCase {
    private ClientPersistence clientPersistence;

    private static Logger log = LogManager.getLogger(GetClientUseCase.class);

    public Client handle(String sharedKey){
        String methodSignature = "Initialization method handle in GetClientUseCase";
        log.debug(methodSignature);
        log.info(AppGMLConstants.PROCESSING_USE_CASE +"GetClientUseCase");
        return clientPersistence.findClientBySharedKey(sharedKey);
    }
}
