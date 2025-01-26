package com.example.bsm.service;

import com.example.bsm.request.HospitalRequest;
import com.example.bsm.response.HospitalResponse;

public interface HospitalService {


    HospitalResponse registerHospital(HospitalRequest hospitalRequest,int adminId);

    HospitalResponse findHospitalById(int hospitalId);

    HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId);
}
