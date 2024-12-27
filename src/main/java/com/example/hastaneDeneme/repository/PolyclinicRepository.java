package com.example.hastaneDeneme.repository;

import com.example.hastaneDeneme.entity.PolyclinicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface PolyclinicRepository extends JpaRepository<PolyclinicEntity,Long> {
    List<PolyclinicEntity> findByPolyclinicId(Optional<Long> polyclinicId);
}
