package com.example.hastaneDeneme.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class DoctorResponseDto {
    private Long doctorId;
    private String doctorName;

    public DoctorResponseDto(Long doctorId, String doctorName) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    public DoctorResponseDto() {
    }

    @Override
    public String toString() {
        return "DoctorResponseDto{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
