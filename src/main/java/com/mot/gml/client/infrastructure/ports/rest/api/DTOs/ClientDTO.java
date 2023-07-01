package com.mot.gml.client.infrastructure.ports.rest.api.DTOs;

import com.mot.gml.client.domain.exceptions.constants.ExceptionsGMLConstants;
import com.mot.gml.client.domain.models.client.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@NoArgsConstructor
public class ClientDTO implements Serializable {
    private BigInteger id;
    @NotNull(message = ExceptionsGMLConstants.INVALID_SHARED_KEY_NULL)
    @NotEmpty(message = ExceptionsGMLConstants.INVALID_SHARED_KEY_NULL)
    private String sharedKey;
    @NotNull(message = ExceptionsGMLConstants.INVALID_NAME_NULL)
    @NotEmpty(message = ExceptionsGMLConstants.INVALID_NAME_NULL)
    private String name;
    @NotNull(message = ExceptionsGMLConstants.INVALID_EMAIL_NULL)
    @NotEmpty(message = ExceptionsGMLConstants.INVALID_EMAIL_NULL)
    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = ExceptionsGMLConstants.INVALID_EMAIL)
    private String email;
    @Pattern(regexp = "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")
    private String phone;
    private Date startDate;
    private Date endDate;

    public ClientDTO(Client client){
        this.id = client.getId();
        this.sharedKey = client.getSharedKey();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.endDate = client.getEndDate();
        this.startDate = client.getStartDate();
    }
}
