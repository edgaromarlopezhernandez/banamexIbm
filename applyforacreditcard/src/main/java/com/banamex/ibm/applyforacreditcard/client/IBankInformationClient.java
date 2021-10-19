package com.banamex.ibm.applyforacreditcard.client;

import com.banamex.ibm.applyforacreditcard.dto.LocationDTO;

import java.util.List;

public interface IBankInformationClient {
    public List<LocationDTO> getAllLocations();
}
