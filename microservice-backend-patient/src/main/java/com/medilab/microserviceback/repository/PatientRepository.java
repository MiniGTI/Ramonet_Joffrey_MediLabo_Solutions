package com.medilab.microserviceback.repository;

import com.medilab.microserviceback.model.Patient;

import java.util.List;
import java.util.Optional;

/**
 * Interface to give mandatory methods to repository classes.
 */
public interface PatientRepository {
    
    List<Patient> findAll();
    
    Optional<Patient> findById(String id);
    
    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);
    
    Patient save(Patient patient);
    
    void deleteById(String id);
}
