package com.example.bsm.serviceimpl;

import com.example.bsm.entity.BloodBank;
import com.example.bsm.entity.Hospital;
import com.example.bsm.exception.BloodBankNotFoundById;
import com.example.bsm.repository.BloodBankRepository;
import com.example.bsm.request.BloodBankRequest;
import com.example.bsm.response.BloodBankResponse;
import com.example.bsm.service.BloodBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BloodBankServiceImpl implements BloodBankService {

    private final BloodBankRepository bloodBankRepository;

    private BloodBankResponse mapToResponse(BloodBank bloodBank){
        return BloodBankResponse.builder()
                .bloodBankId(bloodBank.getBloodBankId())
                .bloodBankName(bloodBank.getBloodBankName())
                .emergencyUnitCount(bloodBank.getEmergencyUintCount())
                .build();
    }
    private BloodBank mapToBloodBank(BloodBankRequest bloodBankRequest,BloodBank bloodBank){
        bloodBank.setBloodBankName(bloodBankRequest.getBloodBankName());
        bloodBank.setEmergencyUintCount(bloodBankRequest.getEmergencyUintCount());
        return bloodBank;
    }


    @Override
    public BloodBankResponse registerBloodBank(BloodBankRequest bloodBankRequest) {
        BloodBank bloodBank=this.mapToBloodBank(bloodBankRequest,new BloodBank());
        bloodBank=bloodBankRepository.save(bloodBank);
        return this.mapToResponse(bloodBank);
    }

    @Override
    public BloodBankResponse findBloodBankBydId(int bloodBankId) {
        Optional<BloodBank> optional= bloodBankRepository.findById(bloodBankId);
        if (optional.isEmpty())
            throw new BloodBankNotFoundById("blood bank not found by id");
        BloodBank bloodBank= optional.get();
        return this.mapToResponse(bloodBank);

    }

    @Override
    public BloodBankResponse updateBloodBank(BloodBankRequest bloodBankRequest, int bloodBandkId) {
        Optional<BloodBank> optional= bloodBankRepository.findById(bloodBandkId);
        if (optional.isEmpty())
            throw new BloodBankNotFoundById("blood bank not find by id");
        BloodBank bloodBank=this.mapToBloodBank(bloodBankRequest,optional.get());
        bloodBankRepository.save(bloodBank);
        return this.mapToResponse(bloodBank);

    }


}
