package com.example.bsm.controller;

import com.example.bsm.request.BloodBankRequest;
import com.example.bsm.response.BloodBankResponse;
import com.example.bsm.service.BloodBankService;
import com.example.bsm.utility.ResponseStructure;
import com.example.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BloodBankController {

    private final BloodBankService bloodBankService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/add-blood-bank")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> registerBloodBank(@RequestBody BloodBankRequest bloodBankRequest){
        BloodBankResponse bloodBankResponse=bloodBankService.registerBloodBank(bloodBankRequest);
        return responseBuilder.success(HttpStatus.CREATED,"Blood bank created",bloodBankResponse);
    }

    @GetMapping("bloodBanks/{bloodBankdId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> findBloodBankById(@PathVariable int bloodBankId){
        BloodBankResponse bloodBankResponse=bloodBankService.findBloodBankBydId(bloodBankId);
        return responseBuilder.success(HttpStatus.FOUND,"Blood bankd Found",bloodBankResponse);
    }

    @PutMapping("bloodBanks/{bloodBankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> updateBloodBank(@RequestBody BloodBankRequest bloodBankRequest,
                                                                                @PathVariable int bloodBandkId){
        BloodBankResponse bloodBankResponse=bloodBankService.updateBloodBank(bloodBankRequest,bloodBandkId);
        return responseBuilder.success(HttpStatus.OK,"updated blood bank",bloodBankResponse);
    }


}
