package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PartOfHistory {
    private Integer ID;
    private Integer ID_car;
    private String description;
    private String type_history;
    private LocalDate date;
}