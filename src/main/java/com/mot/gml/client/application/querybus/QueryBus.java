package com.mot.gml.client.application.querybus;

public interface QueryBus {
    <T> T handle(Query<T> query) throws Exception;
}
