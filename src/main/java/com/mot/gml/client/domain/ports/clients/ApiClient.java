package com.mot.gml.client.domain.ports.clients;


import java.io.IOException;


public interface ApiClient <T, R>{

    T post(R paymentRequest, String target) throws IOException;

}
