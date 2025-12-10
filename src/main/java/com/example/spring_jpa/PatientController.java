package com.example.spring_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Patient registerPatient(@RequestParam String name, @RequestParam String email, @RequestParam LocalDate date) {
        System.out.print("Zarejestrowano");
        return patientService.createPatient(name, email, date);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    //YYYY-MM-DD
    @GetMapping("/patients/{date}")
    public Optional<Patient> getPatientByDate(@PathVariable LocalDate date) {
        return patientService.getPatientsByDate(date);
    }
}