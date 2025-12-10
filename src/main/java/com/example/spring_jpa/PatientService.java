package com.example.spring_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient createPatient(String name, String email, LocalDate date) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setEmail(email);
        patient.setDate(date);
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientsByDate(LocalDate date) {
        return patientRepository.getPatientsByDate(date);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
