package com.example.hastaneDeneme.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "managments")
public class ManagmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managmentId;

    @ManyToOne
    @JoinColumn(name = "polyclinicId", nullable = false)
    private PolyclinicEntity polyclinic;

    @ManyToOne
    @JoinColumn(name = "doctorId", nullable = false)
    private DoctorEntity doctor;

    public ManagmentEntity() {
    }

    public ManagmentEntity(Long managmentId, PolyclinicEntity polyclinic, DoctorEntity doctor) {
        this.managmentId = managmentId;
        this.polyclinic = polyclinic;
        this.doctor = doctor;
    }

    public Long getManagmentId() {
        return managmentId;
    }

    public void setManagmentId(Long managmentId) {
        this.managmentId = managmentId;
    }

    public PolyclinicEntity getPolyclinic() {
        return polyclinic;
    }

    public void setPolyclinic(PolyclinicEntity polyclinic) {
        this.polyclinic = polyclinic;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "ManagmentEntity{" +
                "managmentId=" + managmentId +
                ", polyclinic=" + polyclinic +
                ", doctor=" + doctor +
                '}';
    }
}
