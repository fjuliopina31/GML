package com.mot.gml.client.application.command;

import com.mot.gml.client.application.commandbus.CommandHandler;
import com.mot.gml.client.application.constants.AppGMLConstants;
import com.mot.gml.client.application.usecases.CreateClientUseCase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CreateClientCommandHandler implements CommandHandler<CreateClientCommand> {

    @Autowired
    private CreateClientUseCase createClientUseCase;

    private static final Logger log = LogManager.getLogger(CreateClientCommandHandler.class);

    @Override
    public void handle(CreateClientCommand command) throws Exception {
        String methodSignature = "Initialization method handle in CreateClientCommandHandler";
        log.debug(methodSignature);
        log.info(AppGMLConstants.EXECUTING_COMMAND_HANDLER +"CreateClientCommandHandler");
        command.setClient(createClientUseCase.handle(command.getClient()));
    }
}
