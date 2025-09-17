package com.example.demoscheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Professor {
    @Id
    private Long id;
    private String name;
    private String email;
    private String availableFrom;
    private String availableTo;
}