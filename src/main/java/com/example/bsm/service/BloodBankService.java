package com.example.bsm.service;

import com.example.bsm.request.BloodBankRequest;
import com.example.bsm.response.BloodBankResponse;

public interface BloodBankService {
    BloodBankResponse registerBloodBank(BloodBankRequest bloodBankRequest);

    BloodBankResponse findBloodBankBydId(int bloodBankId);

    BloodBankResponse updateBloodBank(BloodBankRequest bloodBankRequest, int bloodBandkId);
}
