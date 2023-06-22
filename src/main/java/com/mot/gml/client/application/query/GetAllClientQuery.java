package com.mot.gml.client.application.query;

import com.mot.gml.client.application.querybus.Query;
import com.mot.gml.client.domain.models.client.Client;
import lombok.*;

import java.util.stream.Stream;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClientQuery extends Query<Stream<Client>> {
    private Stream<Client> clients;
}
