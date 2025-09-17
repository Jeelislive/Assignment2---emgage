package com.example.demoscheduler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Timetable {
    @Id
    private Long id;
    private String professorName;
    private String branch;
    private String timeSlot;
    private String scheduleDay;
    private String subject;
}