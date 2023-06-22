package com.mot.gml.client.infrastructure.adapters.models.providers.gml.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GMLRequest implements IClientRequest, Serializable {
    private String language;
    private String command;
    private boolean test;
}
