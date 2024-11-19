package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "userLogin_Id")
    private Users user;

    private String comment;
    private Double grade;

}
