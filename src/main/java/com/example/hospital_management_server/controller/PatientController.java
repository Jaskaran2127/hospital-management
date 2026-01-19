package com.example.hospital_management_server.controller;

import com.example.hospital_management_server.dto.BloodGroupCountDto;
import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import com.example.hospital_management_server.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/get-all")
    public ResponseEntity<List<PatientDto>> getAllPatientList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) LocalDate birthDate
    ){
        List<PatientDto> patientDtoList = patientService.getAllPatient(name, email, birthDate);
        return ResponseEntity.ok(patientDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getById(@PathVariable("id") Long Id){
        PatientDto patientDtoList = patientService.getPatientById(Id);
        return ResponseEntity.ok(patientDtoList);
    }

    @GetMapping("blood-group/{bg}")
    public ResponseEntity<List<PatientDto>> getByBloodGroup(@PathVariable("bg") BloodGroupTypes bg){
        List<PatientDto> patientDtoList = patientService.getAllPatientByBloodGroup(bg);
        return ResponseEntity.ok(patientDtoList);
    }

    @GetMapping("blood-group")
    public ResponseEntity<List<BloodGroupCountDto>> getbyBloodGroupType (){
        List<BloodGroupCountDto> patientDtoList = patientService.getGroupByBloodGroup();
        return ResponseEntity.ok(patientDtoList);
    }
}
