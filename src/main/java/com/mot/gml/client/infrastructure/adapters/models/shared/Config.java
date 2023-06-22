package com.mot.gml.client.infrastructure.adapters.models.shared;

import lombok.Data;

@Data
public class Config {
    private String apiKey;
    private String apiLogin;
    private String accountId;
    private String language;
    private String notifyUrl;
    private String merchantId;
}
