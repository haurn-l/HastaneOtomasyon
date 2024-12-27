package com.example.hastaneDeneme.controller;

import com.example.hastaneDeneme.dto.PolyclinicCreateRequestDto;
import com.example.hastaneDeneme.dto.PolyclinicResponseDto;
import com.example.hastaneDeneme.entity.PolyclinicEntity;
import com.example.hastaneDeneme.enums.Status;
import com.example.hastaneDeneme.service.PolyclinicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/polyclinics")
public class PolyclinicController {
    PolyclinicService polyclinicService;

    public PolyclinicController(PolyclinicService polyclinicService) {
        this.polyclinicService = polyclinicService;
    }
    @GetMapping
    public List<PolyclinicResponseDto> getAllPolyclinics(){
    return polyclinicService.getAllPolyclinics();
    }
    @GetMapping("/{polyclinicId}")
    public PolyclinicResponseDto getOnePolyclinic(@PathVariable Long polyclinicId){
     return polyclinicService.getOnePolyclinicByPolyclinicId(polyclinicId);
    }

    @PostMapping("/add")
    public PolyclinicEntity addPolyclinic(@RequestBody PolyclinicCreateRequestDto polyclinicCreateRequestDto){
        return polyclinicService.addPolyclinic(polyclinicCreateRequestDto);
    }
    @PutMapping("/statusupdate/{polyclinicId}")
    public Status updatePolyclinicStatus(@PathVariable Long polyclinicId){
        return polyclinicService.updatePolyclinicStatus(polyclinicId);
    }


}
