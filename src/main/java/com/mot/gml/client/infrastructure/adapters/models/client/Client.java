package com.mot.gml.client.infrastructure.adapters.models.client;

import lombok.Data;

import java.util.Date;

@Data
public class Client {
    private String sharedKey;
    private String name;
    private String email;
    private String phone;
    private Date startDate;
    private Date endDate;
}
