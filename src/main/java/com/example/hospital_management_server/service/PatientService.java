package com.example.hospital_management_server.service;

import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PatientDto> getAllPatient(String name, String email, LocalDate birthDate){
        List<Patient> allPatients;
        if(name != null){
            allPatients = patientRepository.findDistinctByNameContaining(name);
        } else if (email != null) {
            allPatients = patientRepository.findByEmail(email);
        }
        else if (birthDate != null) {
            allPatients=patientRepository.findByBirthDate(birthDate);
        }
        else{
            allPatients=patientRepository.findAll();
        }
        List<PatientDto> allPatientDto = allPatients.stream().map(patient -> modelMapper.map(patient,PatientDto.class)).toList();
            return allPatientDto;
    }

    public PatientDto getPatientById(Long Id){
            Patient matchedPatient = patientRepository.findById(Id).orElseThrow(()-> new RuntimeException(("No Patient exist with id " + Id)));
            PatientDto dtoPatient = modelMapper.map(matchedPatient, PatientDto.class);
            return dtoPatient;
    }
}
