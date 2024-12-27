package com.example.hastaneDeneme.entity;

import com.example.hastaneDeneme.enums.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "polyclinic")
public class PolyclinicEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long polyclinicId;

        @Column(name = "polyclinicName",nullable = false)
        private String polyclinicName;

        @Enumerated(EnumType.STRING)
        private Status status;

        public PolyclinicEntity() {
        }

        public PolyclinicEntity(Long polyclinicId, String polyclinicName, Status status) {
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

        @Override
        public String toString() {
                return "PolyclinicEntity{" +
                        "polyclinicId=" + polyclinicId +
                        ", polyclinicName='" + polyclinicName + '\'' +
                        ", status=" + status +
                        '}';
        }
}
