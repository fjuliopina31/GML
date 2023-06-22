package com.mot.gml.client.application.query;

import com.mot.gml.client.application.querybus.Query;
import com.mot.gml.client.domain.models.client.Client;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GetClientQuery extends Query<Client> {
    private Client client;
}
