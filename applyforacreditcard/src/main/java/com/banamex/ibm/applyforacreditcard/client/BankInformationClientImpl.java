package com.banamex.ibm.applyforacreditcard.client;

import com.banamex.ibm.applyforacreditcard.dto.LocationDTO;
import com.banamex.ibm.applyforacreditcard.exception.WrongBanamexResourceException;
import com.banamex.ibm.applyforacreditcard.util.ExceptionMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BankInformationClientImpl  implements IBankInformationClient{
    @Autowired
    private AuxMethodsForClientStuff auxMethods;

    @Override
    public List<LocationDTO> getAllLocations() {
        String url = "http://localhost:8083/api/v1/locations";
        ResponseEntity<String> response = auxMethods.requestForData(url, HttpMethod.GET);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            String  locationsDTOS = response.getBody();
            locationsDTOS = auxMethods.formatAsJson(locationsDTOS);
            return auxMethods.jsonStringToLocationDTO(locationsDTOS);
        }
        else{
            throw new WrongBanamexResourceException(ExceptionMessages.INVALID_RESOURCE.getMessage());
        }
    }
}
