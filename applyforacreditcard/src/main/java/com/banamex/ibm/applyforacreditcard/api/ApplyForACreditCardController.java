package com.banamex.ibm.applyforacreditcard.api;

import com.banamex.ibm.applyforacreditcard.dto.ApplyRequest;
import com.banamex.ibm.applyforacreditcard.dto.ApplyResponse;
import com.banamex.ibm.applyforacreditcard.service.ApplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apply")
public class ApplyForACreditCardController {

    @Autowired
    private ApplyServiceImpl service;

    @PostMapping
    public ResponseEntity<ApplyResponse> applyForACreditCard(@RequestBody ApplyRequest payload){
        ApplyResponse response = service.applyForACreditCard(payload);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
