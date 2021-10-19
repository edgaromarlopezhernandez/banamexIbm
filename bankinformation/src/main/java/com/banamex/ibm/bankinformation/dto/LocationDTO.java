package com.banamex.ibm.bankinformation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDTO implements Serializable {
    private String id;
    private String set;
    private String name;
    private String street;
    private String location;
    private String adjoiningStreet;
    private String adjoiningStreet2;
    private String phone;
    private String subSet;
    private String initialAttentionTime;
    private String endAttentionTime;
    private String longitude;
    private String latitude;
    private String state;
    private String branchType;
}