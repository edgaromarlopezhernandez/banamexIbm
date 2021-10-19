package com.banamex.ibm.bankinformation.service;

import com.banamex.ibm.bankinformation.dto.LocationDTO;

import java.util.List;

public interface IBankLocationsService {

    public List<LocationDTO> getAllBankLocations();
}
