package com.example.bsm.service;

import com.example.bsm.request.SampleRequest;
import com.example.bsm.response.SampleResponse;

public interface SampleService {

    SampleResponse addSample(SampleRequest sampleRequest);

    SampleResponse findSample(int sampleId);

    SampleResponse updateSample(SampleRequest sampleRequest, int sampleId);
}
