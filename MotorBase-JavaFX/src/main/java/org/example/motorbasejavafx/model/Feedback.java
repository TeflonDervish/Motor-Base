package org.example.motorbasejavafx.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Feedback {
    private Integer ID_user;
    private Integer ID_car;
    private String comment;
    private Float grade;
}