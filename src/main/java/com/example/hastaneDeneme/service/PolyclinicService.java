package com.example.hastaneDeneme.service;

import com.example.hastaneDeneme.dto.PolyclinicCreateRequestDto;
import com.example.hastaneDeneme.dto.PolyclinicResponseDto;
import com.example.hastaneDeneme.entity.PolyclinicEntity;
import com.example.hastaneDeneme.enums.Status;
import com.example.hastaneDeneme.exception.CustomException;
import com.example.hastaneDeneme.repository.PolyclinicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PolyclinicService {

        PolyclinicRepository polyclinicRepository;

    public PolyclinicService(PolyclinicRepository polyclinicRepository) {
        this.polyclinicRepository = polyclinicRepository;
    }

    public List<PolyclinicResponseDto>getAllPolyclinics() {
        List<PolyclinicEntity> list = polyclinicRepository.findAll();
        List<PolyclinicResponseDto> viewList = new ArrayList<>();
        for (PolyclinicEntity entity : list) {
            PolyclinicResponseDto dto = new PolyclinicResponseDto(
                    entity.getPolyclinicId(),
                    entity.getPolyclinicName(),
                    entity.getStatus()
            );
            viewList.add(dto);
        }
        return viewList;
    }

    public PolyclinicEntity addPolyclinic(PolyclinicCreateRequestDto polyclinicCreateRequestDto) {
            PolyclinicEntity savePolyclinic = new PolyclinicEntity();
        savePolyclinic.setPolyclinicId(polyclinicCreateRequestDto.getPolyclinicId());
        savePolyclinic.setPolyclinicName(polyclinicCreateRequestDto.getPolyclinicName());
        savePolyclinic.setStatus(polyclinicCreateRequestDto.getStatus());

            return polyclinicRepository.save(savePolyclinic);
    }

    public Status updatePolyclinicStatus(Long polyclinicId) {
       PolyclinicEntity entity = polyclinicRepository.findById(polyclinicId).orElseThrow
                (()->new CustomException("Poliklinik Bulunamadi!"));
        if (entity.getStatus()== Status.AKTIF){
            entity.setStatus(Status.PASIF);
            return entity.getStatus();
        }else {
            entity.setStatus(Status.AKTIF);
        }
        polyclinicRepository.save(entity);
        return entity.getStatus();
    }

    public PolyclinicResponseDto getOnePolyclinicByPolyclinicId(Long polyclinicId) {
            PolyclinicEntity entity=polyclinicRepository.findById(polyclinicId).orElseThrow(()->new CustomException(" !ERROR! This idli does not have a polyclinic!"));
            PolyclinicResponseDto dto = new PolyclinicResponseDto();
            dto.setPolyclinicId(entity.getPolyclinicId());
            dto.setPolyclinicName(entity.getPolyclinicName());
            dto.setStatus(entity.getStatus());
        return dto;
    }
}
