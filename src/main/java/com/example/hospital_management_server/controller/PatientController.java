package com.example.hospital_management_server.controller;

import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/get-all")
    public ResponseEntity<List<PatientDto>> getAllPatientList(){
        List<PatientDto> patientDtoList = patientService.getAllPatient();
        return ResponseEntity.ok(patientDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable("id") Long Id){
        PatientDto patientDtoList = patientService.getPatientById(Id);
        return ResponseEntity.ok(patientDtoList);
    }

}
