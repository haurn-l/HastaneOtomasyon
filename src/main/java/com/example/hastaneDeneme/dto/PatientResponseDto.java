package com.example.hastaneDeneme.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class PatientResponseDto {
    private Long patientId;
    private String patientName;

    public PatientResponseDto() {
    }

    public PatientResponseDto(Long patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "PatientResponseDto{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                '}';
    }
}
