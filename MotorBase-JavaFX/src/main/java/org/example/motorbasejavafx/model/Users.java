package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.motorbasejavafx.enums.Roles;

@Data
@NoArgsConstructor
public class Users{
    private Long Id;
    private String password;
    private String phoneNumber;
    private String email;
    private String name;
    private String surname;
    private String userPhoto;
    private String birthday;
    private String city;
    private String drivingExperience;
    private String about;
    private Roles user_role;

}