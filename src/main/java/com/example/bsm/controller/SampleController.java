package com.example.bsm.controller;

import com.example.bsm.request.SampleRequest;
import com.example.bsm.response.SampleResponse;
import com.example.bsm.service.SampleService;
import com.example.bsm.utility.ResponseStructure;
import com.example.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SampleController {

    private final SampleService sampleService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/add-sample")
    public ResponseEntity<ResponseStructure<SampleResponse>> addSample(@RequestBody SampleRequest sampleRequest){
        SampleResponse sampleResponse=sampleService.addSample(sampleRequest);
        return responseBuilder.success(HttpStatus.CREATED,"Sample created",sampleResponse);
    }
    @GetMapping("/samples/{sampleId}")
    public ResponseEntity<ResponseStructure<SampleResponse>> findSample(@PathVariable int sampleId){
        SampleResponse sampleResponse=sampleService.findSample(sampleId);
        return responseBuilder.success(HttpStatus.FOUND,"Sample found",sampleResponse);
    }

    @PutMapping("/samples/{sampleId}")
    public ResponseEntity<ResponseStructure<SampleResponse>> updateSample(@RequestBody SampleRequest sampleRequest,
                                                                          @PathVariable int sampleId){
        SampleResponse sampleResponse=sampleService.updateSample(sampleRequest,sampleId);
        return responseBuilder.success(HttpStatus.OK,"Sample found",sampleResponse);
    }


}
