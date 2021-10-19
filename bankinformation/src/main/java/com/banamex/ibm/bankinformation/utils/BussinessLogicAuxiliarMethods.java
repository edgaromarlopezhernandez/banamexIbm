package com.banamex.ibm.bankinformation.utils;

import com.banamex.ibm.bankinformation.dto.LocationDTO;
import com.banamex.ibm.bankinformation.exceptions.DataNotFoundException;
import com.banamex.ibm.bankinformation.exceptions.WrongBanamexResourceException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class BussinessLogicAuxiliarMethods {

    public String requestBanamexUrl(){
        try{
            String banamexJson = "https://www.banamex.com/localizador/jsonP/json5.json";
            URL url = new URL(banamexJson);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            String inputText = "";
            while ((inputLine = in.readLine()) != null) {
                inputText = inputText + inputLine;
            }
            in.close();

            return inputText;
        }catch(MalformedURLException exception){
            throw new WrongBanamexResourceException(ExceptionMessages.INVALID_RESOURCE.getMessage());
        }catch(IOException exception){
            throw new DataNotFoundException(ExceptionMessages.DATA_PROCESSING_ERROR.getMessage());
        }
    }

    public String formatAsAJson(String inputText){
        if(inputText.startsWith("jsonCallback({\"Servicios\":")){
            inputText = inputText.substring(26, inputText.length() -3);
        }else{
            throw new DataNotFoundException(ExceptionMessages.DATA_INCONSISTENCY.getMessage());
        }
        return inputText;
    }

    public List<LocationDTO> castDataToLocationDTO(String inputText, List<LocationDTO> locationsList){

        int jsonStartPosition = 0;
        int jsonEndPosition = 0;

        for(int i = 0; i< inputText.length(); i++){
            if(inputText.charAt(i) == '['){
                jsonStartPosition = i;
            }
            if(inputText.charAt(i) == ']'){
                jsonEndPosition = i;

                String singleJson = inputText.substring(jsonStartPosition, jsonEndPosition);
                String[] parts = singleJson.split("\"");

                if(Integer.parseInt(parts[3]) == 100 || Integer.parseInt(parts[3]) == 300){
                    LocationDTO locationDTO = LocationDTO.builder()
                            .id(deleteUnnecessaryData(parts[1]))//Test1
                            .set(deleteUnnecessaryData(parts[3]))
                            .name(deleteUnnecessaryData(parts[5]))
                            .street(deleteUnnecessaryData(parts[7]))
                            .location(deleteUnnecessaryData(parts[9]))
                            .adjoiningStreet(deleteUnnecessaryData(parts[13]))
                            .adjoiningStreet2(deleteUnnecessaryData(parts[15]))
                            .phone(deleteUnnecessaryData(parts[17]))
                            .subSet(deleteUnnecessaryData(parts[19]))
                            .initialAttentionTime(deleteUnnecessaryData(parts[21]))//27
                            .endAttentionTime(deleteUnnecessaryData(parts[23]))//29
                            .longitude(deleteUnnecessaryData(parts[31]))
                            .latitude(deleteUnnecessaryData(parts[33]))
                            .state(deleteUnnecessaryData(parts[35]))
                            .branchType(deleteUnnecessaryData(parts[39]))
                            .build();

                    locationsList.add(locationDTO);
                }

                jsonStartPosition = 0;
                jsonEndPosition = 0;
                singleJson = "";
                parts = null;
            }
        }
        return locationsList;
    }

    public String deleteUnnecessaryData(String stringToProcess){
        stringToProcess = stringToProcess.replace("\"", "");
        stringToProcess = stringToProcess.replace("[", "");
        stringToProcess = stringToProcess.replace("]", "");
        stringToProcess = stringToProcess.replace(",", "");
        return stringToProcess;
    }
}