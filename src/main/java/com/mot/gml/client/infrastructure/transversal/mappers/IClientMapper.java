package com.mot.gml.client.infrastructure.transversal.mappers;

import com.mot.gml.client.domain.models.client.Client;
import com.mot.gml.client.infrastructure.adapters.persistence.entities.ClientEntity;
import com.mot.gml.client.infrastructure.ports.rest.api.DTOs.CreateClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CreateClientRequestMapper.class, CreateClientResponseMapper.class})
public interface IClientMapper {

    @Mapping(ignore = true, target = "id")
    Client createClientDTOToClient(CreateClientDTO createClientDTO);

    CreateClientDTO clientToCreateClientDTO(Client client);

    ClientEntity clientToClientEntity(Client client);

    @Mapping(ignore = true, target = "id")
    Client clientEntityToClient(ClientEntity clientEntity);
}
