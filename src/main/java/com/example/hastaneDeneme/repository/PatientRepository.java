package com.example.hastaneDeneme.repository;

import com.example.hastaneDeneme.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
}
