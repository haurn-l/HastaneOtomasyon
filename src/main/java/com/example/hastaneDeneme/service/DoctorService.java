package com.example.hastaneDeneme.service;

import com.example.hastaneDeneme.dto.DoctorCreateRequestDto;
import com.example.hastaneDeneme.dto.DoctorResponseDto;
import com.example.hastaneDeneme.entity.DoctorEntity;
import com.example.hastaneDeneme.entity.PolyclinicEntity;
import com.example.hastaneDeneme.enums.DoctorStatus;
import com.example.hastaneDeneme.enums.Status;
import com.example.hastaneDeneme.exception.CustomException;
import com.example.hastaneDeneme.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    DoctorRepository doctorRepository;
    ManagmentService managmentService;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, ManagmentService managmentService) {
        this.doctorRepository = doctorRepository;
        this.managmentService = managmentService;
    }

    public List<DoctorResponseDto> getAllDoctors() {
        List<DoctorEntity> list = doctorRepository.findAll();
        List<DoctorResponseDto> viewList = new ArrayList<>();
        for (DoctorEntity entity : list) {
            DoctorResponseDto dto = new DoctorResponseDto( entity.getDoctorId(), entity.getDoctorName() );
            viewList.add(dto);
        }
        return viewList;
    }

    public DoctorEntity getOneDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(()-> new CustomException("ERROR! There is no doctor with this Id!"));
    }

    public DoctorStatus updateDoctorStatus(Long doctorId) {
        DoctorEntity entity = doctorRepository.findById(doctorId).orElseThrow
                (()->new CustomException("Doctor NOT FOUND"));
        if (entity.getStatus()== DoctorStatus.MESAIDE){
            entity.setStatus(DoctorStatus.IZINLI);
            return entity.getStatus();
        }else {
            entity.setStatus(DoctorStatus.MESAIDE);
        }
        doctorRepository.save(entity);
        return entity.getStatus();
    }

    public DoctorEntity addDoctor(DoctorCreateRequestDto doctorCreateRequestDto) {
        if (doctorRepository.findById(doctorCreateRequestDto.getDoctorId()).isPresent()) {
            throw new CustomException("Doctor already exists!");
        }

        DoctorEntity savedDoctor = new DoctorEntity();
        savedDoctor.setDoctorId(doctorCreateRequestDto.getDoctorId());
        savedDoctor.setDoctorName(doctorCreateRequestDto.getDoctorName());
        savedDoctor.setStatus(doctorCreateRequestDto.getStatus());

        DoctorEntity savedDoctorEntity = doctorRepository.save(savedDoctor);

        managmentService.assignDoctorToPolyclinic(savedDoctorEntity.getDoctorId(), doctorCreateRequestDto.getPolyclinicId());

        return savedDoctorEntity;
    }
}
