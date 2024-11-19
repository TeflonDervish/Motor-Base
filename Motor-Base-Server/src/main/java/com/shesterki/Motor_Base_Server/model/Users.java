package com.shesterki.Motor_Base_Server.model;


import com.shesterki.Motor_Base_Server.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;
    @Column(name="password")
    private String password;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email")
    private String email;
    private String name;
    private String surname;
    @Column(name="user_photo")
    private String userPhoto;
    private LocalDate birthday;
    private String city;
    @Column(name="driving_experience")
    private String drivingExperience;
    private String about;
    @Enumerated(EnumType.STRING)
    private Roles user_role;

}
