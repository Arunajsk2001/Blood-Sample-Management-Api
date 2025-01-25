package com.example.bsm.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankRequest {

    private String bloodBankName;
    private int emergencyUintCount;
}
