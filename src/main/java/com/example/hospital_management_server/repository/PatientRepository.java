package com.example.hospital_management_server.repository;

import com.example.hospital_management_server.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByEmail(String email);

    public List<Patient> findDistinctByNameContaining(String name);

    public List<Patient> findByBirthDate(LocalDate date);


}