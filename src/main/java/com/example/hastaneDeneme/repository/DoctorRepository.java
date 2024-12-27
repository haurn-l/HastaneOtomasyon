package com.example.hastaneDeneme.repository;

import com.example.hastaneDeneme.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
}
