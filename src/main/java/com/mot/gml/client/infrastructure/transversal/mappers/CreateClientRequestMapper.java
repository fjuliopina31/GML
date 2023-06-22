package com.mot.gml.client.infrastructure.transversal.mappers;

import com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.GMLRequest;
import com.mot.gml.client.infrastructure.transversal.transform.ClientTransform;
import org.springframework.stereotype.Component;

@Component
public class CreateClientRequestMapper {

    private ClientTransform clientTransform = ClientTransform.builder().build();
    public String map(GMLRequest value){
        return clientTransform.transformClientObjectToString(value);
    }

    public GMLRequest map(String value){
        return (GMLRequest) clientTransform.transformClientStringToObject(value, new GMLRequest());
    }
}
