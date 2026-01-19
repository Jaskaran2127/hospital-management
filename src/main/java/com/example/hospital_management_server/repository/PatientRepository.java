package com.example.hospital_management_server.repository;

import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public List<Patient> findByEmail(String email);

    public List<Patient> findDistinctByNameContaining(String name);

    public List<Patient> findByBirthDate(LocalDate date);

    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    public List<Patient> findByBloodGroup(@Param(("bloodGroup")) BloodGroupTypes bloodGroup);
}