package com.example.hospital_management_server.controller;

import com.example.hospital_management_server.dto.BloodGroupCountDto;
import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import com.example.hospital_management_server.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            @RequestParam(required = false) LocalDate birthDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        List<PatientDto> patientDtoList = patientService.getAllPatient(name, email, birthDate, pageable);
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

    @PostMapping
    public ResponseEntity<PatientDto> createPatient(@RequestBody PatientDto patientDto) {
        PatientDto createdPatient = patientService.createPatient(patientDto);
        return ResponseEntity.ok(createdPatient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto patientDto) {
        PatientDto updatedPatient = patientService.updatePatient(id, patientDto);
        return ResponseEntity.ok(updatedPatient);
    }
}
