package com.example.hospital_management_server.entity;

import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import com.example.hospital_management_server.entity.types.GenderTypes;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "patient",uniqueConstraints = {
//        @UniqueConstraint(name="unique_patient_email",columnNames = {"email"}),
        @UniqueConstraint(name="unique_patient_name_birthDate",columnNames = {"name","birthDate"})
},indexes = {@Index(name = "idx_patient_birth_date",columnList = "birthDate")})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "patient_name",nullable = false,length = 40)
    private String name;

    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private GenderTypes gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupTypes bloodGroup;

//    @CreationTimestamp
//    @Column(updatable = false)
//    private String createdAt;

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
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}