package com.mot.gml.client.application.usecases;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateClientUseCaseTest {
    @Mock
    private ClientPersistence clientPersistence;
    @InjectMocks
    private CreateClientUseCase createClientUseCase;

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
        when(clientPersistence.persist(client)).thenReturn(clientResponse);
        Client clientResponse = createClientUseCase.handle(client);
        System.out.println("clientResponse:"+clientResponse);
        assertNotNull(clientResponse);
        assertEquals(this.clientResponse,clientResponse);
        verify(clientPersistence,times(1)).persist(client);
    }
}