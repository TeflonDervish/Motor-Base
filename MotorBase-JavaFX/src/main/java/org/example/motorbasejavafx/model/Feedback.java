package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Feedback {
    private Integer ID_user;
    private Integer ID_car;
    private String comment;
    private Float grade;
}