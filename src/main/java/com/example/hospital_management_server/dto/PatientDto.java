package com.example.hospital_management_server.dto;

import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import com.example.hospital_management_server.entity.types.GenderTypes;

import java.time.LocalDate;

public class PatientDto {
    private Long id;

    private String name;

    private LocalDate birthDate;

    private String email;

    private GenderTypes gender;

    private BloodGroupTypes bloodGroup;

    public PatientDto(Long id, String name, LocalDate birthDate, String email, GenderTypes gender, BloodGroupTypes bloodGroup) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    public PatientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderTypes getGender() {
        return gender;
    }

    public void setGender(GenderTypes gender) {
        this.gender = gender;
    }

    public BloodGroupTypes getbloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(BloodGroupTypes bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
