package com.mot.gml.client.infrastructure.transversal.mappers;

import com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.GMLResponse;
import com.mot.gml.client.infrastructure.transversal.transform.ClientTransform;
import org.springframework.stereotype.Component;

@Component
public class CreateClientResponseMapper {

    private ClientTransform clientTransform = ClientTransform.builder().build();

    public String map(GMLResponse value){
        return clientTransform.transformClientObjectToString(value);
    }

    public GMLResponse map(String value){
        return (GMLResponse) clientTransform.transformClientStringToObject(value, new GMLResponse());
    }
}
