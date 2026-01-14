package com.example.hospital_management_server.service;

import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PatientDto> getAllPatient(){
        try {
            List<Patient> allPatients = patientRepository.findAll();
            List<PatientDto> allPatientDto = allPatients.stream().map(patient -> modelMapper.map(patient,PatientDto.class)).toList();
            return allPatientDto;
        }
        catch (Exception e) {
            throw new RuntimeException("Error fetching patients: " + e.getMessage(), e);
        }
    }

    public PatientDto getPatientById(Long Id){
        try {
            Patient matchedPatient = patientRepository.findById(Id).orElseThrow(()-> new RuntimeException(("No Patient exist with id " + Id)));
            PatientDto dtoPatient = modelMapper.map(matchedPatient, PatientDto.class);
            return dtoPatient;
        }
        catch (Exception e) {
            throw new RuntimeException("Error fetching patients: " + e.getMessage(), e);
        }
    }
}
