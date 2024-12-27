package com.example.hastaneDeneme.service;

import com.example.hastaneDeneme.dto.PatientCreateRequestDto;
import com.example.hastaneDeneme.dto.PatientResponseDto;
import com.example.hastaneDeneme.entity.DoctorEntity;
import com.example.hastaneDeneme.entity.PatientEntity;
import com.example.hastaneDeneme.enums.DoctorStatus;
import com.example.hastaneDeneme.enums.PatientStatus;
import com.example.hastaneDeneme.exception.CustomException;
import com.example.hastaneDeneme.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    PatientRepository patientRepository;
    public List<PatientResponseDto> getAllPatient() {
        List<PatientEntity> entity = patientRepository.findAll();
        List<PatientResponseDto> viewList = new ArrayList<>();
        for (PatientEntity entity1 :entity){
            PatientResponseDto patientResponseDto = new PatientResponseDto(
                    entity1.getPatientId(),entity1.getPatientName()
            );
            viewList.add(patientResponseDto);
        }
        return viewList;
    }

    public PatientEntity getOnePatient(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(()-> new CustomException("ERROR! There is no patient with this Id!"));
    }

    public PatientStatus updatePatientStatus(Long patientId) {
        PatientEntity entity = patientRepository.findById(patientId).orElseThrow
                (()->new CustomException("Patient NOT FOUND"));
        if (entity.getStatus()== PatientStatus.TEDAVI_BEKLIYOR){
            entity.setStatus(PatientStatus.TEDAVI_OLDU);
            return entity.getStatus();
        }else {
            entity.setStatus(PatientStatus.TEDAVI_BEKLIYOR);
        }
        patientRepository.save(entity);
        return entity.getStatus();
    }
    public PatientEntity addPatient(PatientCreateRequestDto patientCreateRequestDto) {
        PatientEntity newPatient = new PatientEntity();
        newPatient.setPatientName(patientCreateRequestDto.getPatientName());
        newPatient.setStatus(patientCreateRequestDto.getStatus() != null ? patientCreateRequestDto.getStatus() : PatientStatus.TEDAVI_BEKLIYOR);

        return patientRepository.save(newPatient);
    }
}
