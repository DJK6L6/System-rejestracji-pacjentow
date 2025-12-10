package com.example.spring_jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PatientRepository patientRepository) {
        return args -> {
            Patient patient1 = new Patient();
            patient1.setName("Alicja");
            patient1.setEmail("alicja@gmail.com");
            patient1.setDate(LocalDate.now());

            Patient patient2 = new Patient();
            patient2.setName("Romek");
            patient2.setEmail("romek@gmail.com");
            patient2.setDate(LocalDate.now().plusDays(1));

            patientRepository.save(patient1);
            patientRepository.save(patient2);

            System.out.println("Dodano pacjentów.");
        };
    }
}
