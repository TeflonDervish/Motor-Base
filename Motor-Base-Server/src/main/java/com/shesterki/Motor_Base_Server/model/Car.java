package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    private String type;
    private String mark;
    private String model;
    private Integer yearMake;
    private Integer run;
    private String color;
    private String typeBody;
    private String gearbox;
    private Integer enginePowers;
    private Double engineVolume;
    @Column(name="all_driver")
    private String allDriver;
    private String imageUrl;


}
