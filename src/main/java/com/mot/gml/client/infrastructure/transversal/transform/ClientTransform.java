package com.mot.gml.client.infrastructure.transversal.transform;


import com.google.gson.Gson;
import com.mot.gml.client.domain.models.client.Client;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientTransform {
    private Client client;
    private static Logger log = LogManager.getLogger(ClientTransform.class);

    public String transformClientObjectToString(Object object){
        String methodSignature = "Initialization method transformClientObjectToString";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public Object transformClientStringToObject(String jsonString, Object object){
        String methodSignature = "Initialization method transformClientStringToObject";
        log.debug(methodSignature);
        Gson gson = new Gson();
        return gson.fromJson(jsonString, object.getClass());
    }
}
