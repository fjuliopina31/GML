package com.mot.gml.client.application.usecases;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.domain.ports.persistence.ClientPersistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class GetAllClientUseCaseTest {
    @Mock
    private ClientPersistence clientPersistence;
    @InjectMocks
    private GetAllClientUseCase getAllClientUseCase;
    private Stream<Client> clientStream;
    private Stream<Client> clientsResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Client client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        clientStream = Stream.of(client);
        clientsResponse = clientStream;
    }

    @Test
    void handle() throws Exception {
        when(clientPersistence.findAll()).thenReturn(clientsResponse);
        Stream<Client> clientResponse = getAllClientUseCase.handle();
        System.out.println("clientResponse:"+clientResponse);
        assertNotNull(clientResponse);
        assertEquals(this.clientsResponse,clientResponse);
        verify(clientPersistence,times(1)).findAll();
    }
}
