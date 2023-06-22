package com.mot.gml.client.infrastructure.adapters.models.providers.gml.client;

import com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.response.ClientResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GMLResponse implements IClientResponse, Serializable {
    private String code;
    private String error;
    private ClientResponse clientResponse;
}
