package com.medilab.microserviceback.stub;

import com.medilab.microserviceback.model.Patient;
import com.medilab.microserviceback.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

/**
 * Mock the repository for tests.
 * Get all data from DataBaseStub and use the List<Patient> like the database.
 */
public class PatientRepositoryStub implements PatientRepository {
    
    private final DataBaseStub data = new DataBaseStub();
    private final List<Patient> patients = data.getPatients();
    
    
    @Override
    public List<Patient> findAll() {
        return patients;
    }
    
    @Override
    public Optional<Patient> findById(String id) {
        return patients.stream()
                .filter(patient -> patient.getID()
                        .equals(id))
                .findFirst();
    }
    
    @Override
    public Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName) {
        return patients.stream()
                .filter(patient -> patient.getFirstName()
                        .equals(firstName) && patient.getLastName()
                        .equals(lastName))
                .findFirst();
    }
    
    @Override
    public Patient save(Patient patient) {
        patients.add(patient);
        return patients.stream()
                .filter(saved -> saved.getFirstName()
                        .equals(patient.getFirstName()) && saved.getLastName()
                        .equals(patient.getLastName()))
                .findFirst()
                .get();
    }
    
    @Override
    public void deleteById(String id) {
        patients.removeIf(patient -> patient.getID()
                .equals(id));
    }
    

}
