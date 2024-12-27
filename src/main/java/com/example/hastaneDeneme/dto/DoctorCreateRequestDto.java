package com.example.hastaneDeneme.dto;

import com.example.hastaneDeneme.enums.DoctorStatus;
import lombok.Data;

@Data
public class DoctorCreateRequestDto {
    private Long doctorId;
    private String doctorName;
    private DoctorStatus status; // veya kendi enum tipiniz
    private Long polyclinicId;

    public DoctorCreateRequestDto(Long doctorId, String doctorName, DoctorStatus status, Long polyclinicId) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.status = status;
        this.polyclinicId = polyclinicId;
    }

    public DoctorCreateRequestDto() {
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public Long getPolyclinicId() {
        return polyclinicId;
    }

    public void setPolyclinicId(Long polyclinicId) {
        this.polyclinicId = polyclinicId;
    }
}
