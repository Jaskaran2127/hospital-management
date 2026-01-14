package com.example.hospital_management_server;

import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void findAll(){
        List<Patient> patientList =patientRepository.findAll();
        System.out.println(patientList + "patient");
    }
}
