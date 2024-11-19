package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="PartOfHistory")
public class PartOfHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;

    private String description;
    private LocalDate date;

    @Column(name="type_history")
    private String typeHistory;

}
