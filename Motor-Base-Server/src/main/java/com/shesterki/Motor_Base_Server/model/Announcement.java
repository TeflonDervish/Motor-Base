package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long Id;

    @OneToOne
    @JoinColumn(name = "car_Id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;

    private Double price;
    private LocalDate date;
    private String name;
    private String description;

}
