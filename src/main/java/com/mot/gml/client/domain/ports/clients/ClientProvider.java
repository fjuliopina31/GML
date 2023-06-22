package com.mot.gml.client.domain.ports.clients;

import com.mot.gml.client.domain.models.client.Client;

public interface ClientProvider {
    Client postClientProvider(Client client);
}
