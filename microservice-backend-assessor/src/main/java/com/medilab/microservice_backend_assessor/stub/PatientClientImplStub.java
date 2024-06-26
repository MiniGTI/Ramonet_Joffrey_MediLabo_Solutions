package com.medilab.microservice_backend_assessor.stub;

import com.medilab.microservice_backend_assessor.bean.PatientBean;
import com.medilab.microservice_backend_assessor.microservice_client.PatientClient;

import java.util.List;

/**
 * Mock the patient client for tests.
 * Get all data from DataBaseStub and use the List<PatientBean> like the proxy.
 */
public class PatientClientImplStub implements PatientClient {
    
    private final DataBaseStub dataBaseStub = new DataBaseStub();
    private final List<PatientBean> patients = dataBaseStub.getPatients();
    
    
    @Override
    public PatientBean getPatientById(String id) {
        return patients.stream()
                .filter(patient -> patient.id()
                        .equals(id))
                .toList()
                .getFirst();
    }
}
