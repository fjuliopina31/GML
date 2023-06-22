package com.mot.gml.client.application.querybus;

public interface QueryHandler<T, U extends Query<T>> {
    T handle(U query) throws Exception;
}
