package com.mot.gml.client.infrastructure.adapters.rest.clients;

import com.mot.gml.client.domain.interfaces.IClientRequest;
import com.mot.gml.client.domain.interfaces.IClientResponse;
import com.mot.gml.client.domain.ports.clients.GMLApiClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GMLApiClientImp implements GMLApiClient {

    @Override
    public IClientResponse post(IClientRequest clientRequest, String target) throws Exception {
        return null;
    }
}
