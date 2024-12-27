package com.example.hastaneDeneme.dto;

import com.example.hastaneDeneme.enums.Status;
import lombok.Data;

@Data
public class PolyclinicCreateRequestDto {
    private Long polyclinicId;
    private String polyclinicName;
    private Status status;

    public PolyclinicCreateRequestDto(Long polyclinicId, String polyclinicName, Status status) {
        this.polyclinicId = polyclinicId;
        this.polyclinicName = polyclinicName;
        this.status = status;
    }

    public Long getPolyclinicId() {
        return polyclinicId;
    }

    public void setPolyclinicId(Long polyclinicId) {
        this.polyclinicId = polyclinicId;
    }

    public String getPolyclinicName() {
        return polyclinicName;
    }

    public void setPolyclinicName(String polyclinicName) {
        this.polyclinicName = polyclinicName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
