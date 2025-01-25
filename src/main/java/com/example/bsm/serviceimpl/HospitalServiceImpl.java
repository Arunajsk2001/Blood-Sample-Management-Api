package com.example.bsm.serviceimpl;

import com.example.bsm.entity.Admin;
import com.example.bsm.entity.Hospital;
import com.example.bsm.enums.AdminType;
import com.example.bsm.exception.HospitalNotFoundByIdException;
import com.example.bsm.repository.AdminRepository;
import com.example.bsm.repository.HospitalRepository;
import com.example.bsm.request.HospitalRequest;
import com.example.bsm.response.HospitalResponse;
import com.example.bsm.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final AdminRepository adminRepository;

    private HospitalResponse mapToHospitalResponse(Hospital hospital){
        return HospitalResponse.builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }
    private Hospital mapToHospital(HospitalRequest hospitalRequest,Hospital hospital){

        hospital.setHospitalName(hospitalRequest.getHospitalName());
        return hospital;
    }

    @Override
    public HospitalResponse registerHospital(HospitalRequest hospitalRequest,int adminId) {
         Optional<Admin> optional= adminRepository.findById(adminId);
         if(optional.isEmpty()) {
             throw new RuntimeException("failed to fetch the admin");
         }
         Admin admin=optional.get();
         List<Admin> adminList=new ArrayList<>();
         adminList.add(admin);
         Hospital hospital=new Hospital();
         hospital.setAdmin(adminList);
         hospital=this.mapToHospital(hospitalRequest,new Hospital());

         hospital=hospitalRepository.save(hospital);
         admin.setAdminType(AdminType.Owner);
         return this.mapToHospitalResponse(hospital);
    }



    @Override
    public HospitalResponse findHospitalById(int hospitalId) {
        Optional<Hospital> optional= hospitalRepository.findById(hospitalId);
        if (optional.isEmpty())
            throw new HospitalNotFoundByIdException("hospital not found by id");

        Hospital hospital= optional.get();
        return this.mapToHospitalResponse(hospital);
    }

    @Override
    public HospitalResponse updateHospital(HospitalRequest hospitalRequest, int hospitalId) {

       Optional<Hospital> optional= hospitalRepository.findById(hospitalId);
       if (optional.isEmpty()) {
           throw new HospitalNotFoundByIdException("hospital not found by id");
       }else{
           Hospital hospital=this.mapToHospital(hospitalRequest,optional.get());
           hospitalRepository.save(hospital);
           return this.mapToHospitalResponse(hospital);
       }

    }



}
