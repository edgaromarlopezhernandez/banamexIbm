package com.banamex.ibm.creditcards.exceptions.errorhandler;

import com.banamex.ibm.creditcards.exceptions.GeneralError;
import com.banamex.ibm.creditcards.utils.CustomResponse;
import com.banamex.ibm.creditcards.utils.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
@RestController
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request){
        log.info(request.getDescription(true), request.getContextPath());//Errors tracking must be implemented & an email to master programmer
        return new CustomResponse(false, "Internal Server Error", null).createResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GeneralError.class)
    public ResponseEntity<Object> handleNotFoundExceptions(GeneralError exception, WebRequest request){
        log.info(request.getDescription(true), request.getContextPath());// check other features of webRequest
        return new CustomResponse(false, ErrorMessages.FATAL_ERROR.getMessage(), null).createResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
