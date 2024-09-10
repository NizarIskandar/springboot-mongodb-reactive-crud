package com.example.reactivepatient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.reactivepatient.model.Patient;
import com.example.reactivepatient.service.PatientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Patient> getAllPatients(@RequestParam(required = false) String name) {
        if (name == null) {
            return patientService.findAll();
        } else {
            return patientService.findByName(name);
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Patient> getPatientById(@PathVariable("id") String id) {
        return patientService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Patient> createPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Patient> updatePatient(@PathVariable("id") String id, @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePatient(@PathVariable("id") String id) {
        return patientService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAllPatients() {
        return patientService.deleteAll();
    }
}
