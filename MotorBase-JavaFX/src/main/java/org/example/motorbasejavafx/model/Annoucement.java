package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Annoucement {
    private Integer ID;
    private Integer ID_car;
    private Integer ID_user;
    private String name;
    private String description;
    private Float price;
    private LocalDate date;
}
