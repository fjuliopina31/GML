package com.mot.gml.client.infrastructure.rest.controllers;

import com.mot.gml.client.application.command.CreateClientCommand;
import com.mot.gml.client.application.commandbus.CommandBus;
import com.mot.gml.client.application.query.GetAllClientQuery;
import com.mot.gml.client.application.query.GetClientQuery;
import com.mot.gml.client.application.query.GetClientQueryHandlerTest;
import com.mot.gml.client.application.querybus.QueryBus;
import com.mot.gml.client.domain.models.client.Client;

import com.mot.gml.client.infrastructure.ports.rest.api.DTOs.CreateClientDTO;
import com.mot.gml.client.infrastructure.ports.rest.api.controllers.ClientController;
import com.mot.gml.client.infrastructure.transversal.mappers.IClientMapper;
import com.mot.gml.client.infrastructure.transversal.transform.ClientTransform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @Mock
    private CommandBus commandBus;
    @Mock
    private QueryBus queryBus;
    @Mock
    private IClientMapper clientMapper;
    @InjectMocks
    private ClientController clientController;

    private CreateClientDTO createClientDTO;

    private CreateClientCommand createClientCommand;

    private Client client;

    private ClientTransform clientTransform = ClientTransform.builder().build();

    private GetAllClientQuery queryGetAll;

    private GetClientQuery getClientQuery;

    private Stream<Client> clientStream;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createClientDTO = new CreateClientDTO();
        createClientDTO.setSharedKey("fjulio");
        createClientDTO.setName("Fabio Julio");
        createClientDTO.setEmail("fjulio.pina@gmail.com");
        createClientDTO.setPhone("3042416725");
        createClientDTO.setStartDate(new Date());
        System.out.println("Create clientDTOController");
        client = clientMapper.createClientDTOToClient(createClientDTO);
        createClientCommand = new CreateClientCommand(client);
        System.out.println(createClientCommand);
        System.out.println("Create CreateClientDTO");
        System.out.println(createClientDTO);
        System.out.println("finish setUp");
        client = new Client("fjulio31", "Fabio Julio","fjulio.pina30@gmail.com","3042416725", new Date(), null,null,null);
        createClientCommand.setClient(client);
        clientStream = Stream.of(client);
        queryGetAll = new GetAllClientQuery();
        queryGetAll.setClients(clientStream);
        getClientQuery = new GetClientQuery();
        getClientQuery.setClient(client);

    }

    @Test
    void createClient() throws Exception {
        when(clientMapper.createClientDTOToClient(createClientDTO)).thenReturn(client);
        doNothing().when(commandBus).handle(createClientCommand);
        when(clientMapper.clientToCreateClientDTO(client)).thenReturn(createClientDTO);
        ResponseEntity<CreateClientDTO> response = clientController.createClient(createClientDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(commandBus,times(1)).handle(createClientCommand);
    }

    @Test
    void findAllClient() throws Exception{
        when(clientMapper.createClientDTOToClient(createClientDTO)).thenReturn(client);
        when(queryBus.handle(any())).thenReturn(queryGetAll.getClients());
        when(clientMapper.clientToCreateClientDTO(client)).thenReturn(createClientDTO);
        ResponseEntity<Stream<CreateClientDTO>> response = clientController.getAllClients();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(queryBus,times(1)).handle(any());
    }

    @Test
    void findBySharedKey() throws Exception{
        when(clientMapper.createClientDTOToClient(createClientDTO)).thenReturn(client);
        when(queryBus.handle(any())).thenReturn(client);
        when(clientMapper.clientToCreateClientDTO(client)).thenReturn(createClientDTO);
        ResponseEntity<CreateClientDTO> response = clientController.getClientBySharedKey(client.getSharedKey());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(queryBus,times(1)).handle(any());
    }
}