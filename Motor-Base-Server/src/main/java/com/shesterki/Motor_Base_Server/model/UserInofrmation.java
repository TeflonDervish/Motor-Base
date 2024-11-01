package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "UserInformation")
public class UserInofrmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    private String name;
    private String surname;
    @Column(name="user_photo")
    private String userPhoto;
    private LocalDate birthday;
    private String city;
    @Column(name="driving_experience")
    private String drivingExperience;
    private String about;

}
