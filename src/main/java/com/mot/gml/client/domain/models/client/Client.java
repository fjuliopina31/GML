package com.mot.gml.client.domain.models.client;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
public class Client {
    private BigInteger id;
    private String sharedKey;
    private String name;
    private String email;
    private String phone;
    private Date startDate;
    private Date endDate;
    private String requestMessage;
    private String responseMessage;

    public Client( String sharedKey, String name, String email, String phone, Date startDate, Date endDate, String requestMessage, String responseMessage) {
        this.sharedKey = sharedKey;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.requestMessage = requestMessage;
        this.responseMessage = responseMessage;
    }
}
