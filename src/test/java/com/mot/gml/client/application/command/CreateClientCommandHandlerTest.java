package com.mot.gml.client.application.command;

import com.mot.gml.client.application.usecases.CreateClientUseCase;
import com.mot.gml.client.domain.models.client.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Date;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CreateClientCommandHandlerTest {

    @Mock
    private CreateClientUseCase createClientUseCase;
    @InjectMocks
    private CreateClientCommandHandler createClientCommandHandler;

    private Client client;
    private Client clientResult;
    private CreateClientCommand createClientCommand;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        Client clientCommand = client;
        createClientCommand = new CreateClientCommand(client);
        createClientCommand.setClient(clientCommand);
        clientResult = clientCommand;
    }

    @Test
    void handle() throws Exception {
        when(createClientUseCase.handle(client)).thenReturn(clientResult);
        createClientCommandHandler.handle(createClientCommand);
        verify(createClientUseCase,times(1)).handle(client);
    }
}