package com.example.hastaneDeneme.entity;

import com.example.hastaneDeneme.enums.PatientStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @Column(name = "patientName", nullable = false)
    private String patientName;

    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    @OneToMany(mappedBy = "patient")
    private List<AppointmentEntity> doctors;

    public PatientEntity(Long patientId, String patientName, PatientStatus status, List<AppointmentEntity> doctors) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.status = status;
        this.doctors = doctors;
    }

    public PatientEntity() {
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

    public List<AppointmentEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<AppointmentEntity> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", status=" + status +
                ", doctors=" + doctors +
                '}';
    }
}
