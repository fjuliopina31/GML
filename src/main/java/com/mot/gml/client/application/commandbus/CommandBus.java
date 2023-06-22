package com.mot.gml.client.application.commandbus;

public interface CommandBus {
    void handle(Command command) throws Exception;
}
