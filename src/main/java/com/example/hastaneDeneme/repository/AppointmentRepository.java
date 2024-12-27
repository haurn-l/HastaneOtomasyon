package com.example.hastaneDeneme.repository;

import com.example.hastaneDeneme.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
