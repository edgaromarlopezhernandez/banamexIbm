package com.banamex.ibm.applyforacreditcard.util;

import com.banamex.ibm.applyforacreditcard.dto.ApplyRequest;
import com.banamex.ibm.applyforacreditcard.exception.DataBadRequestException;
import org.springframework.stereotype.Component;

@Component
public class ApplyValidator {

    public ApplyRequest validate(ApplyRequest objectToValidate){
        if(objectToValidate.getName() == null){
            throw new DataBadRequestException(ExceptionMessages.NUL_NAME_NOT_ALLOWED.getMessage());
        }
        if(objectToValidate.getName().isEmpty()){
            throw new DataBadRequestException(ExceptionMessages.EMPTY_NAME_NOT_ALLOWED.getMessage());
        }
        if(!AreLetters.verify(objectToValidate.getName().trim())){
            throw new DataBadRequestException(ExceptionMessages.NOT_A_NAME.getMessage());
        }
        if(!IsNumeric.verifyUnsigned(objectToValidate.getAge().trim()))
            throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_AGE.getMessage());
        if(Integer.parseInt(objectToValidate.getAge().trim()) < 18
                || Integer.parseInt(objectToValidate.getAge()) > 75){
            throw new DataBadRequestException(ExceptionMessages.INVALID_AGE.getMessage());
        }
        if(!IsNumeric.verifyUnsigned(objectToValidate.getPhone().trim()))
            throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_PHONE.getMessage());
        if(objectToValidate.getPhone().trim().length() != 10){
            throw new DataBadRequestException(ExceptionMessages.INVALID_LENGTH_PHONE.getMessage());
        }
        if(!IsNumeric.verifyUnsigned(objectToValidate.getMonthlySalary().trim()))
            throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_SALARY.getMessage());
        if(objectToValidate.getYourPassion() == null){
            throw new DataBadRequestException(ExceptionMessages.NULL_PASSION_NOT_ALLOWED.getMessage());
        }
        if(objectToValidate.getYourPassion().isEmpty()){
            throw new DataBadRequestException(ExceptionMessages.EMPTY_PASSION_NOT_ALLOWED.getMessage());
        }
        if((objectToValidate.getLatitude() == null && objectToValidate.getLongitude() == null)
                && objectToValidate.getPostalCode() == null
                && objectToValidate.getCity() == null
                && objectToValidate.getEstate() == null)
            throw new DataBadRequestException(ExceptionMessages.EMPTY_PASSION_NOT_ALLOWED.getMessage());
        if(objectToValidate.getLatitude() != null && objectToValidate.getLongitude() != null){
            if(objectToValidate.getLatitude().isEmpty() || objectToValidate.getLongitude().isEmpty())
                throw new DataBadRequestException(ExceptionMessages.EMPTY_GPS_NOT_ALLOWED.getMessage());
            if(!IsNumeric.verify(objectToValidate.getLatitude().trim()))
                throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_LATITUDE.getMessage());
            if(!IsNumeric.verify(objectToValidate.getLongitude().trim()))
                throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_LONGITUDE.getMessage());
        }

        if(objectToValidate.getPostalCode() != null){
            if(objectToValidate.getPostalCode().isEmpty())
                throw new DataBadRequestException(ExceptionMessages.EMPTY_POSTAL_CODE_NOT_ALLOWED.getMessage());
            if(!IsNumeric.verifyUnsigned(objectToValidate.getPostalCode()))
                throw new DataBadRequestException(ExceptionMessages.NOT_NUMERIC_POSTAL_CODE.getMessage());
            if(objectToValidate.getPostalCode().trim().length() != 5)
                throw new DataBadRequestException(ExceptionMessages.INCORRECT_LENGTH_POSTAL_CODE.getMessage());
        }

        if(objectToValidate.getCity() != null){
            if(objectToValidate.getCity().isEmpty())
                throw new DataBadRequestException(ExceptionMessages.EMPTY_CITY_NOT_ALLOWED.getMessage());
            if(!AreLetters.verify(objectToValidate.getCity().trim()))
                throw new DataBadRequestException(ExceptionMessages.CITY_ARE_NOT_LETTERS.getMessage());
        }

        if(objectToValidate.getEstate() != null){
            if(objectToValidate.getEstate().isEmpty())
                throw new DataBadRequestException(ExceptionMessages.EMPTY_ESTATE_NOT_ALLOWED.getMessage());
            if(!AreLetters.verify(objectToValidate.getEstate().trim()))
                throw new DataBadRequestException(ExceptionMessages.ESTATE_ARE_NOT_LETTERS.getMessage());
        }

        return objectToValidate;
    }
}
