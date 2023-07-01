package com.mot.gml.client.infrastructure.ports.rest.api.controllers;

import com.mot.gml.client.application.command.CreateClientCommand;
import com.mot.gml.client.application.commandbus.CommandBus;
import com.mot.gml.client.application.query.GetAllClientQuery;
import com.mot.gml.client.application.query.GetClientQuery;
import com.mot.gml.client.application.querybus.QueryBus;
import com.mot.gml.client.domain.exceptions.BusinessException;
import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.infrastructure.ports.rest.api.DTOs.CreateClientDTO;
import com.mot.gml.client.infrastructure.transversal.constants.GMLConstants;
import com.mot.gml.client.infrastructure.transversal.mappers.IClientMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.stream.Stream;

@RestController
@RequestMapping("/client")
@Validated
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private static final Logger log = LogManager.getLogger(ClientController.class);
    private CommandBus commandBus;
    private QueryBus queryBus;
    private IClientMapper clientMapper;

    @GetMapping(value = "/", params = "sharedKey")
    public ResponseEntity<CreateClientDTO> getClientBySharedKey(@RequestParam(name = "sharedKey") String sharedKey) {
        try {
            String methodSignature = "Initialization method in getClientBySharedKey";
            log.debug(methodSignature);
            log.info(GMLConstants.REQUEST_IN_CONTROLLER + sharedKey);
            Client client = new Client();
            client.setSharedKey(sharedKey);
            GetClientQuery query = new GetClientQuery(client);
            Client clientResponse = queryBus.handle(query);
            log.debug(GMLConstants.QUERY_TO_QUERYBUS + query);
            CreateClientDTO createClientDTO = new CreateClientDTO(clientResponse);
            return ResponseEntity.ok(createClientDTO);
        } catch (BusinessException exception) {
            throw new ResponseStatusException(exception.getStatus(), exception.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    public ResponseEntity<Stream<CreateClientDTO>> getAllClients() throws Exception {
        String methodSignature = "Initialization method in getAllClients";
        log.debug(methodSignature);
        GetAllClientQuery query = new GetAllClientQuery();
        Stream<Client> clientsResponse = queryBus.handle(query);
        log.debug(GMLConstants.QUERY_TO_QUERYBUS + query);
        return ResponseEntity.ok(clientsResponse.map(CreateClientDTO::new));
    }

    @PostMapping("/")
    public ResponseEntity<CreateClientDTO> createClient(@RequestBody @Valid CreateClientDTO clientDTO) throws Exception {
        try {
            String methodSignature = "Initialization method in createPayment";
            log.debug(methodSignature);
            log.info(GMLConstants.REQUEST_IN_CONTROLLER + clientDTO);
            Client clientModel = clientMapper.createClientDTOToClient(clientDTO);
            CreateClientCommand command = new CreateClientCommand(clientModel);
            commandBus.handle(command);
            log.debug(GMLConstants.COMMAND_TO_COMMAND_BUS + command);
            CreateClientDTO createClientDTO = clientMapper.clientToCreateClientDTO(command.getClient());
            return ResponseEntity.ok(createClientDTO);
        } catch (BusinessException exception) {
            throw new ResponseStatusException(exception.getStatus(), exception.getMessage(), exception.getCause());
        }
    }
}
