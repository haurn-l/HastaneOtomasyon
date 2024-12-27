package com.example.hastaneDeneme.service;

import com.example.hastaneDeneme.entity.DoctorEntity;
import com.example.hastaneDeneme.entity.ManagmentEntity;
import com.example.hastaneDeneme.entity.PolyclinicEntity;
import com.example.hastaneDeneme.exception.CustomException;
import com.example.hastaneDeneme.repository.DoctorRepository;
import com.example.hastaneDeneme.repository.ManagmentRepository;
import com.example.hastaneDeneme.repository.PolyclinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagmentService {
     ManagmentRepository managmentRepository;
     PolyclinicRepository polyclinicRepository;
     DoctorRepository doctorRepository;

    @Autowired
    public ManagmentService(ManagmentRepository managmentRepository, PolyclinicRepository polyclinicRepository, DoctorRepository doctorRepository) {
        this.managmentRepository = managmentRepository;
        this.polyclinicRepository = polyclinicRepository;
        this.doctorRepository = doctorRepository;
    }

    public void assignDoctorToPolyclinic(Long doctorId, Long polyclinicId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new CustomException("Doctor not found"));
        PolyclinicEntity polyclinic = polyclinicRepository.findById(polyclinicId).orElseThrow(() -> new CustomException("Polyclinic not found"));

        ManagmentEntity managment = new ManagmentEntity();
        managment.setDoctor(doctor);
        managment.setPolyclinic(polyclinic);

        managmentRepository.save(managment);
    }

    public List<ManagmentEntity> getAllManagments() {
        return managmentRepository.findAll();
    }
    public List<ManagmentEntity> getDoctorsByPolyclinicId(Long polyclinicId) {
        List<ManagmentEntity> managmentEntities = managmentRepository.findByPolyclinic_PolyclinicId(polyclinicId);

        if (managmentEntities.isEmpty()) {
            throw new CustomException("No doctors found for the specified polyclinic ID.");
        }

        return managmentEntities;
    }


}
