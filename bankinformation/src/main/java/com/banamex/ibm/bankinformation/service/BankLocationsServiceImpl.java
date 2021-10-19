package com.banamex.ibm.bankinformation.service;

import com.banamex.ibm.bankinformation.dto.LocationDTO;
import com.banamex.ibm.bankinformation.utils.BussinessLogicAuxiliarMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankLocationsServiceImpl implements IBankLocationsService{
    @Autowired
    private BussinessLogicAuxiliarMethods auxMethods;

    @Override
    public List<LocationDTO> getAllBankLocations() {

        String inputText = auxMethods.requestBanamexUrl();

        inputText = auxMethods.formatAsAJson(inputText);

        List<LocationDTO> locationsList = new ArrayList<>();
        locationsList = auxMethods.castDataToLocationDTO(inputText, locationsList);

        /*locationsList = locationsList.stream()
                .filter(location -> location.getSet().equals("100") || location.getSet().equals("300"))
                .collect(Collectors.toList());
*/
        return locationsList;
    }
}