package com.example.reactivepatient.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reactivepatient.model.Patient;
import com.example.reactivepatient.repository.PatientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientService {
    
@Autowired
PatientRepository patientRepository;

public Flux<Patient> findAll() {
    return patientRepository.findAll();
}

public  Flux<Patient> findByName(String name){
    return patientRepository.findByName(name);
}

public Mono<Patient> findById(String id) {
    return patientRepository.findById(id);
  }

  public Mono<Patient> save(Patient patient) {
    return patientRepository.save(patient);
  }

  public Mono<Patient> update(String id, Patient patient) {
    return patientRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
        .flatMap(optionalPatient -> {
          if (optionalPatient.isPresent()) {
            patient.setId(id);
            return patientRepository.save(patient);
          }

          return Mono.empty();
        });
  }

  public Mono<Void> deleteById(String id) {
    return patientRepository.deleteById(id);
  }

  public Mono<Void> deleteAll() {
    return patientRepository.deleteAll();
  }

}
