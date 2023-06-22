package com.mot.gml.client.infrastructure.adapters.persistence.entities;

import com.mot.gml.client.domain.models.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class ClientEntity {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sharedKey", unique = true)
    private String sharedKey;
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    private String phone;
    private Date startDate;
    private Date endDate;

    public Client toClient() {
        Client client = new Client();
        BeanUtils.copyProperties(this, client);
        return client;
    }
}
