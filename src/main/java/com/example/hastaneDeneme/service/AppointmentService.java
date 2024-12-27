package com.example.hastaneDeneme.service;

import com.example.hastaneDeneme.entity.AppointmentEntity;
import com.example.hastaneDeneme.entity.DoctorEntity;
import com.example.hastaneDeneme.entity.PatientEntity;
import com.example.hastaneDeneme.exception.CustomException;
import com.example.hastaneDeneme.repository.AppointmentRepository;
import com.example.hastaneDeneme.repository.DoctorRepository;
import com.example.hastaneDeneme.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AppointmentService {
     AppointmentRepository appointmentRepository;
     DoctorRepository doctorRepository;
     PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void createAppointment(Long doctorId, Long patientId, LocalDate appointmentDate) {
        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new CustomException("Doctor not found with ID: " + doctorId));
        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new CustomException("Patient not found with ID: " + patientId));

        AppointmentEntity appointment = new AppointmentEntity();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setAppointmentDate(appointmentDate);
        appointmentRepository.save(appointment);
    }
}
