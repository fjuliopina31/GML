package com.mot.gml.client.infrastructure.adapters.models.providers.gml.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Root(name = "transactionResponse",strict = false)
public class ClientResponse implements Serializable {
    @Element(name = "sharedKey")
    private String sharedKey;
    @Element(name = "name")
    private String name;
    @Element(name = "email")
    private String email;
    @Element(name = "phone")
    private String phone;
    @Element(name = "startDate")
    private Date startDate;
    @Element(name = "endDate")
    private Date endDate;
}
