package com.example.reactivepatient.repository;

import java.time.LocalDate;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.mongodb.repository.Query;

import com.example.reactivepatient.model.Address;
import com.example.reactivepatient.model.Patient;

import reactor.core.publisher.Flux;

@Repository

public interface PatientRepository extends ReactiveMongoRepository<Patient, String> {
  Flux<Patient> findByName(String name);
  Flux<Patient> findByPhonenumber(String phonenumber);
  Flux<Patient> findByGender(String gender); 
  Flux<Patient> findByBirthdate(LocalDate birthdate);
  Flux<Patient> findByAddress(Address address);
}
