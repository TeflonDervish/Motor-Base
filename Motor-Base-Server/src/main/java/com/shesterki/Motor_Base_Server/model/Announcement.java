package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Users user;

    private Double price;
    private LocalDate date;
    private String description;

}
