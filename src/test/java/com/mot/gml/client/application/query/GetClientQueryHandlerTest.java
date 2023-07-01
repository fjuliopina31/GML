package com.mot.gml.client.application.query;

import com.mot.gml.client.application.usecases.GetClientUseCase;
import com.mot.gml.client.domain.models.client.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static org.mockito.Mockito.*;

public class GetClientQueryHandlerTest {

    @Mock
    private GetClientUseCase clientUseCase;

    @InjectMocks
    private GetClientQueryHandler getClientQueryHandler;

    private Client client;
    private Client clientResult;
    private GetClientQuery getClientQuery;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        Client clientQuery = client;
        getClientQuery = new GetClientQuery(client);
        getClientQuery.setClient(clientQuery);
        clientResult = clientQuery;
    }
    @Test
    public void handle() throws Exception {
        when(clientUseCase.handle(client.getSharedKey())).thenReturn(clientResult);
        getClientQueryHandler.handle(getClientQuery);
        verify(clientUseCase,times(1)).handle(client.getSharedKey());
    }
}
