package com.example.hastaneDeneme.controller;

import com.example.hastaneDeneme.entity.ManagmentEntity;
import com.example.hastaneDeneme.service.ManagmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/managments")
public class ManagmentController {
    ManagmentService managmentService;

    public ManagmentController(ManagmentService managmentService) {
        this.managmentService = managmentService;
    }
    @GetMapping
    public List<ManagmentEntity> getAllManagments() {
        return managmentService.getAllManagments();
    }

    @GetMapping("/byPolyclinic/{polyclinicId}")
    public List<ManagmentEntity> getDoctorsByPolyclinicId(@PathVariable Long polyclinicId) {
        return managmentService.getDoctorsByPolyclinicId(polyclinicId);
    }

}
