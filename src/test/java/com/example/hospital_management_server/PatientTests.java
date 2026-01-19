package com.example.hospital_management_server;

import com.example.hospital_management_server.PatientService.dto.BloodGroupCountDto;
import com.example.hospital_management_server.PatientService.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void groupAllBYBloodGroup(){
        List<BloodGroupCountDto> patientList =patientRepository.groupByBloodGroup();
        System.out.println(patientList + "patient");
    }
}
