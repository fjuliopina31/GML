package com.mot.gml.client.application.usecases;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetClientUseCaseTest {
    @Mock
    private ClientPersistence clientPersistence;
    @InjectMocks
    private GetClientUseCase getClientUseCase;

    private Client client;
    private Client clientResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        clientResponse = client;
    }

    @Test
    void handle() throws Exception {
        when(clientPersistence.findClientBySharedKey(client.getSharedKey())).thenReturn(clientResponse);
        Client clientResponse = getClientUseCase.handle(client.getSharedKey());
        System.out.println("clientResponse:"+clientResponse);
        assertNotNull(clientResponse);
        assertEquals(this.clientResponse,clientResponse);
        verify(clientPersistence,times(1)).findClientBySharedKey(client.getSharedKey());
    }
}
