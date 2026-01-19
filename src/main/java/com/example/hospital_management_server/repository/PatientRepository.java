package com.example.hospital_management_server.repository;

import com.example.hospital_management_server.dto.BloodGroupCountDto;
import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public Page<Patient> findByEmail(String email, Pageable pageable);

    public Page<Patient> findDistinctByNameContaining(String name,Pageable pageable);

    public Page<Patient> findByBirthDate(LocalDate date,Pageable pageable);


    //or you can write query like "SELECT p from Patient p where p.bloodGroup = :bloodGroup"
    @Query("SELECT p from Patient p where p.bloodGroup = ?1")
    public List<Patient> findByBloodGroup(@Param(("bloodGroup")) BloodGroupTypes bloodGroup);

    @Query(value = "SELECT * FROM patient WHERE blood_group = ?1",nativeQuery = true)
    public List<Patient> findByNativeBloodGroup(@Param(("bloodGroup")) BloodGroupTypes bloodGroup);

    @Query("SELECT new com.example.hospital_management_server.dto.BloodGroupCountDto(p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup")
    public List<BloodGroupCountDto> groupByBloodGroup();
}