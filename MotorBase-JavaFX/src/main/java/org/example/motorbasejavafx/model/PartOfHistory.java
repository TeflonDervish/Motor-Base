package org.example.motorbasejavafx.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PartOfHistory {
    private Integer ID;
    private Integer ID_car;
    private String description;
    private String type_history;
    private LocalDate date;
}