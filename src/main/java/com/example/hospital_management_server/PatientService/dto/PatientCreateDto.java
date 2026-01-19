package com.example.hospital_management_server.PatientService.dto;

import lombok.Data;

import java.time.LocalDate;

public class PatientCreateDto {
    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    public PatientCreateDto(Long id, String name, LocalDate birthDate, String email, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
