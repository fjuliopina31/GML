package com.mot.gml.client.application.query;

import com.mot.gml.client.application.usecases.GetAllClientUseCase;
import com.mot.gml.client.application.usecases.GetClientUseCase;
import com.mot.gml.client.domain.models.client.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

public class GetAllClientQueryHandlerTest {

    @Mock
    private GetAllClientUseCase clientUseCase;

    @InjectMocks
    private GetAllClientQueryHandler getAllClientQueryHandler;

    private Client client;
    private Stream<Client> clientStream;
    private Stream<Client> clientStreamResult;
    private GetAllClientQuery getClientQuery;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        clientStream = Stream.of(client);
        Stream<Client> clientsQuery = clientStream;
        getClientQuery = new GetAllClientQuery(clientStream);
        getClientQuery.setClients(clientsQuery);
        clientStreamResult = clientsQuery;
    }
    @Test
    public void handle() throws Exception {
        when(clientUseCase.handle()).thenReturn(clientStreamResult);
        getAllClientQueryHandler.handle(getClientQuery);
        verify(clientUseCase,times(1)).handle();
    }
}
