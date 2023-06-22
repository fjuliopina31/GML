package com.mot.gml.client.infrastructure.ports.rest.api.DTOs;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.GMLRequest;
import com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.GMLResponse;
import com.mot.gml.client.infrastructure.transversal.transform.ClientTransform;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CreateClientDTO extends ClientDTO{
    private GMLRequest gmlRequest;
    private GMLResponse gmlResponse;

    public CreateClientDTO(Client client){
        super(client);
        ClientTransform clientTransform = ClientTransform.builder().build();
        gmlRequest = (GMLRequest) clientTransform.transformClientStringToObject(client.getRequestMessage(), new GMLRequest());
        gmlResponse = (GMLResponse) clientTransform.transformClientStringToObject(client.getResponseMessage(), new GMLResponse());
    }
}
