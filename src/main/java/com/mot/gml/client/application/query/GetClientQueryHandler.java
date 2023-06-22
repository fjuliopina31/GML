package com.mot.gml.client.application.query;

import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.application.querybus.QueryHandler;
import com.mot.gml.client.application.usecases.GetClientUseCase;
import com.mot.gml.client.domain.models.client.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientQueryHandler implements QueryHandler<Client, GetClientQuery> {

    @Autowired
    private GetClientUseCase useCase;

    public GetClientQueryHandler(GetClientUseCase useCase) {
        this.useCase = useCase;
    }

    private static final Logger log = LogManager.getLogger(GetClientQueryHandler.class);

    @Override
    public Client handle(GetClientQuery query) throws Exception {
        String methodSignature = "Initialization method handle in GetClientQueryHandler";
        log.debug(methodSignature);
        log.info(AppGMLConstants.EXECUTING_QUERY_HANDLER +"GetClientQueryHandler");
        return useCase.handle(query.getClient().getSharedKey());
    }
}
