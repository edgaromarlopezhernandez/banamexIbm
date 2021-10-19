package com.banamex.ibm.applyforacreditcard.service;

import com.banamex.ibm.applyforacreditcard.dto.ApplyRequest;
import com.banamex.ibm.applyforacreditcard.dto.ApplyResponse;

public interface IApplyService {
    public ApplyResponse applyForACreditCard(ApplyRequest payload);
}
