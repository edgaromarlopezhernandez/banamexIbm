package com.banamex.ibm.applyforacreditcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplyRequest {
    private String name;
    private String age;
    private String phone;
    private String monthlySalary;
    private String yourPassion;
    private String latitude;
    private String longitude;
    private String postalCode;
    private String city;
    private String estate;
}
