package com.example.hastaneDeneme.controller;

import com.example.hastaneDeneme.dto.PatientCreateRequestDto;
import com.example.hastaneDeneme.dto.PatientResponseDto;
import com.example.hastaneDeneme.entity.PatientEntity;
import com.example.hastaneDeneme.enums.PatientStatus;
import com.example.hastaneDeneme.service.AppointmentService;
import com.example.hastaneDeneme.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    PatientService patientService;
    AppointmentService appointmentService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientResponseDto> getAllPatient(){
        return patientService.getAllPatient();
    }

    @GetMapping("/{patientId}")
    public PatientEntity getOnePatient(@PathVariable Long patientId){
        return patientService.getOnePatient(patientId);
    }

    @PutMapping("/statusupdate/{patientId}")
    public PatientStatus updatePatientStatus(@PathVariable Long patientId){
        return patientService.updatePatientStatus(patientId);
    }

    @PostMapping("/add")//date yyyy-MM-dd
    public PatientEntity addPatient(@RequestBody PatientCreateRequestDto patientCreateRequestDto) {
        PatientEntity savedPatient = patientService.addPatient(patientCreateRequestDto);
        appointmentService.createAppointment(patientCreateRequestDto.getDoctorId(), savedPatient.getPatientId(),
                LocalDate.parse(patientCreateRequestDto.getAppointmentDate())
        );
        return savedPatient;
    }
}
