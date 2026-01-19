package com.example.hospital_management_server.PatientService.dto;

import com.example.hospital_management_server.PatientService.entity.types.BloodGroupTypes;

public class BloodGroupCountDto {
    private BloodGroupTypes bloodGroup;

    private Long count;

    public BloodGroupCountDto(BloodGroupTypes bloodGroup, Long count) {
        this.bloodGroup = bloodGroup;
        this.count = count;
    }

    public BloodGroupCountDto() {
    }

    public BloodGroupTypes getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroupTypes bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BloodGroupCountDto{" +
                "bloodGroup=" + bloodGroup +
                ", count=" + count +
                '}';
    }

}
