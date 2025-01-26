package com.example.bsm.controller;

import com.example.bsm.request.HospitalRequest;
import com.example.bsm.request.UserRequest;
import com.example.bsm.response.HospitalResponse;
import com.example.bsm.response.UserResponse;
import com.example.bsm.service.HospitalService;
import com.example.bsm.service.UserService;
import com.example.bsm.utility.ResponseStructure;
import com.example.bsm.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/admins/{adminId}/hospitals")
    public ResponseEntity<ResponseStructure<HospitalResponse>> registerHospital(@RequestBody @Valid HospitalRequest hospitalRequest,@PathVariable int adminId){
         HospitalResponse hospitalResponse=hospitalService.registerHospital(hospitalRequest,adminId);
         return responseBuilder.success(HttpStatus.CREATED,"Hospital created",hospitalResponse);
    }
    @GetMapping("/hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> findHospitalById(@PathVariable int hospitalId){
        HospitalResponse response=hospitalService.findHospitalById(hospitalId);
        return responseBuilder.success(HttpStatus.FOUND,"Hospital Found",response);
    }

    @PutMapping("/hospital/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> updateHospital(@RequestBody HospitalRequest hospitalRequest,
                                                                              @PathVariable int hospitalId){
        HospitalResponse hospitalResponse=hospitalService.updateHospital(hospitalRequest,hospitalId);
        return responseBuilder.success(HttpStatus.OK,"updated hospital",hospitalResponse);
    }



}
