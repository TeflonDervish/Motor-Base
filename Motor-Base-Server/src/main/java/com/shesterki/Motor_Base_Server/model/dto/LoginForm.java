package com.shesterki.Motor_Base_Server.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {

    private String phoneNumber;
    private String password;
}
