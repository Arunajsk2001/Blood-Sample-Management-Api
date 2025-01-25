package com.example.bsm.serviceimpl;

import com.example.bsm.entity.Sample;
import com.example.bsm.exception.SampleNotFoundByIdException;
import com.example.bsm.repository.SampleRepository;
import com.example.bsm.request.SampleRequest;
import com.example.bsm.response.SampleResponse;
import com.example.bsm.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepositroy;

    public SampleResponse mapToResponse(Sample sample){
        return SampleResponse.builder()
                .sampleId(sample.getSampleId())
                .bloodGroup(sample.getBloodGroup())
                .quantity(sample.getQuantity())
                .availability(sample.isAvailability())
                .emergencyUnits(sample.getEmergencyUnits())
                .availableUnits(sample.getAvailableUnits())
                .build();

    }

    public Sample mapToSample(SampleRequest sampleRequest,Sample sample){
        sample.setBloodGroup(sampleRequest.getBloodGroup());
        sample.setAvailability(sampleRequest.isAvailability());
        sample.setQuantity(sampleRequest.getQuantity());
        sample.setEmergencyUnits(sampleRequest.getEmergencyUnits());
        sample.setAvailableUnits(sampleRequest.getAvailableUnits());
        return sample;
    }




    @Override
    public SampleResponse addSample(SampleRequest sampleRequest) {
       Sample sample=this.mapToSample(sampleRequest,new Sample());
       sample=sampleRepositroy.save(sample);
       return this.mapToResponse(sample);
    }

    @Override
    public SampleResponse findSample(int sampleId) {
         Optional<Sample> optional= sampleRepositroy.findById(sampleId);
         if(optional.isEmpty())
             throw new SampleNotFoundByIdException("sample not found");

          Sample sample= optional.get();
          return this.mapToResponse(sample);
    }

    @Override
    public SampleResponse updateSample(SampleRequest sampleRequest, int sampleId) {
        Optional<Sample> optional= sampleRepositroy.findById(sampleId);
        if(optional.isEmpty())
            throw new SampleNotFoundByIdException("sample not found by Id");
        Sample sample= this.mapToSample(sampleRequest,optional.get());
        sampleRepositroy.save(sample);
        return this.mapToResponse(sample);
    }


}
