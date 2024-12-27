package com.example.hastaneDeneme.entity;

import com.example.hastaneDeneme.enums.DoctorStatus;
import com.example.hastaneDeneme.enums.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @Column(name = "doctorName", nullable = false)
    private String doctorName;

    @Enumerated(EnumType.STRING)
    private DoctorStatus status;

    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> patientDoctors;

    public DoctorEntity(Long doctorId, String doctorName, DoctorStatus status, List<AppointmentEntity> patientDoctors) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.status = status;
        this.patientDoctors = patientDoctors;
    }

    public DoctorEntity() {
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

    public List<AppointmentEntity> getPatientDoctors() {
        return patientDoctors;
    }

    public void setPatientDoctors(List<AppointmentEntity> patientDoctors) {
        this.patientDoctors = patientDoctors;
    }

    @Override
    public String toString() {
        return "DoctorEntity{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", status=" + status +
                ", patientDoctors=" + patientDoctors +
                '}';
    }
}
