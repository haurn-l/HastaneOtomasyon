package com.example.hastaneDeneme.controller;

import com.example.hastaneDeneme.dto.DoctorCreateRequestDto;
import com.example.hastaneDeneme.dto.DoctorResponseDto;
import com.example.hastaneDeneme.entity.DoctorEntity;
import com.example.hastaneDeneme.enums.DoctorStatus;

import com.example.hastaneDeneme.service.DoctorService;
import com.example.hastaneDeneme.service.ManagmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    DoctorService doctorService;
    ManagmentService managmentService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public List<DoctorResponseDto> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    @GetMapping("/{doctorId}")
    public DoctorEntity getOneDoctor(@PathVariable Long doctorId){
        return doctorService.getOneDoctorById(doctorId);
    }
    @PutMapping("/statusupdate/{doctorId}")
    public DoctorStatus updateDoctorStatus(@PathVariable Long doctorId){
        return doctorService.updateDoctorStatus(doctorId);
    }
    @PostMapping("/add")
    public DoctorEntity addDoctor(@RequestBody DoctorCreateRequestDto doctorCreateRequestDto) {
        DoctorEntity savedDoctor = doctorService.addDoctor(doctorCreateRequestDto);

        managmentService.assignDoctorToPolyclinic(savedDoctor.getDoctorId(), doctorCreateRequestDto.getPolyclinicId());

        return savedDoctor;
    }

}
