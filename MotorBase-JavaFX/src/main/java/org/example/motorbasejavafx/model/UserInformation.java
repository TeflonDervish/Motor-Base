package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserInformation {
    private String name;
    private String surname;
    private String user_photo;
    private LocalDate birthday;
    private String city;
    private String driving_experience;
    private String about;
}

