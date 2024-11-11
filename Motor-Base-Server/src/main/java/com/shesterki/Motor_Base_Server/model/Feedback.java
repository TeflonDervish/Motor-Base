package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Data
@NoArgsConstructor
@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "car_Id")
    @Column(name="ID_car")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "userLogin_Id")
    @Column(name="ID_user")
    private UserLogin userLogin;

    private String comment;
    private Double grade;

}
