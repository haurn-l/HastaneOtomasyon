package com.example.hastaneDeneme.repository;

import com.example.hastaneDeneme.entity.ManagmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagmentRepository extends JpaRepository<ManagmentEntity,Long> {
    List<ManagmentEntity> findByPolyclinic_PolyclinicId(Long polyclinicId);

}
