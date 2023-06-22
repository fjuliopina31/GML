package com.mot.gml.client.domain.ports.clients;

import com.mot.gml.client.domain.interfaces.IClientRequest;
import com.mot.gml.client.domain.interfaces.IClientResponse;

public interface GMLApiClient <T extends IClientResponse, R extends IClientRequest>{

    T post(R clientRequest, String target) throws Exception;
}
