package com.example.hastaneDeneme.dto;

import com.example.hastaneDeneme.enums.PatientStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientCreateRequestDto {
    private String patientName;
    private PatientStatus status; // Hasta durumu (örn: AKTIF, PASIF gibi)
    private Long doctorId; // Hasta eklendiğinde atanacak doktorun ID'si
    private String appointmentDate; // Randevu tarihi (yyyy-MM-dd formatında)

    public PatientCreateRequestDto(String patientName, PatientStatus status, Long doctorId, String appointmentDate) {
        this.patientName = patientName;
        this.status = status;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public PatientCreateRequestDto() {
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public PatientStatus getStatus() {
        return status;
    }

    public void setStatus(PatientStatus status) {
        this.status = status;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}



