package com.banamex.ibm.bankinformation.api;

import com.banamex.ibm.bankinformation.dto.LocationDTO;
import com.banamex.ibm.bankinformation.service.BankLocationsServiceImpl;
import com.banamex.ibm.bankinformation.utils.CustomResponse;
import com.banamex.ibm.bankinformation.utils.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @Autowired
    private BankLocationsServiceImpl service;

    @RequestMapping
    public ResponseEntity<Object> getAll(){
        List<LocationDTO> bankLocations = service.getAllBankLocations();
        if(bankLocations.isEmpty()){
            return new CustomResponse(true, ResponseMessages.NO_LOCATIONS_FOUND.getMessage(), null).createResponse(HttpStatus.NOT_FOUND);
        }
        else {
            return new CustomResponse(true, ResponseMessages.OK.getMessage(), bankLocations).createResponse();
        }
    }
}
