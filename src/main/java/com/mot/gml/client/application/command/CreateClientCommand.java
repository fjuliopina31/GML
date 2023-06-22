package com.mot.gml.client.application.command;

import com.mot.gml.client.application.commandbus.Command;
import com.mot.gml.client.domain.models.client.Client;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class CreateClientCommand extends Command {
    Client client;
}
