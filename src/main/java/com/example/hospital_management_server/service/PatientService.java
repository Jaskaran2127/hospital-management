package com.example.hospital_management_server.service;

import com.example.hospital_management_server.dto.BloodGroupCountDto;
import com.example.hospital_management_server.dto.PatientDto;
import com.example.hospital_management_server.entity.Patient;
import com.example.hospital_management_server.entity.types.BloodGroupTypes;
import com.example.hospital_management_server.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PatientDto> getAllPatient(String name, String email, LocalDate birthDate ,Pageable pageable){
        Page<Patient> allPatients;
        if(name != null){
            allPatients = patientRepository.findDistinctByNameContaining(name,pageable);
        } else if (email != null) {
            allPatients = patientRepository.findByEmail(email,pageable);
        }
        else if (birthDate != null) {
            allPatients=patientRepository.findByBirthDate(birthDate,pageable);
        }
        else{
            allPatients=patientRepository.findAll(pageable);
        }
        List<PatientDto> allPatientDto = allPatients.stream().map(patient -> modelMapper.map(patient,PatientDto.class)).toList();
            return allPatientDto;
    }

    public PatientDto getPatientById(Long Id){
            Patient matchedPatient = patientRepository.findById(Id).orElseThrow(()-> new RuntimeException(("No Patient exist with id " + Id)));
            PatientDto dtoPatient = modelMapper.map(matchedPatient, PatientDto.class);
            return dtoPatient;
    }

    public List<PatientDto> getAllPatientByBloodGroup(BloodGroupTypes bloodGroup){
        System.out.println("check in here");
        List<Patient> allPatients=patientRepository.findByBloodGroup(BloodGroupTypes.A);
        List<PatientDto> allPatientDto = allPatients.stream().map(patient -> modelMapper.map(patient,PatientDto.class)).toList();
        return allPatientDto;
    }

    public List<BloodGroupCountDto> getGroupByBloodGroup(){
        System.out.println("check in here");
        List<BloodGroupCountDto> allPatients=patientRepository.groupByBloodGroup();
        return allPatients;
    }
}
