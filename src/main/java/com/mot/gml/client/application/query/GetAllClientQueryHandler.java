package com.mot.gml.client.application.query;


import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.application.querybus.QueryHandler;
import com.mot.gml.client.application.usecases.GetAllClientUseCase;
import com.mot.gml.client.domain.models.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class GetAllClientQueryHandler implements QueryHandler<Stream<Client>, GetAllClientQuery> {

    @Autowired
    private GetAllClientUseCase useCase;

    public GetAllClientQueryHandler(GetAllClientUseCase useCase) {
        this.useCase = useCase;
    }

    private static final Logger log = LogManager.getLogger(GetAllClientQueryHandler.class);

    @Override
    public Stream<Client> handle(GetAllClientQuery query) throws Exception {
        String methodSignature = "Initialization method handle in GetAllClientQueryHandler";
        log.debug(methodSignature);
        log.info(AppGMLConstants.EXECUTING_QUERY_HANDLER +"GetAllClientQueryHandler");
        return useCase.handle();
    }
}
