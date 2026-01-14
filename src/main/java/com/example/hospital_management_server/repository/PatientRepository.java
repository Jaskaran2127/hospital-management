package com.example.hospital_management_server.repository;

import com.example.hospital_management_server.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public Optional<Patient> findByEmail(String email);

}