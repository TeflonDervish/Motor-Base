package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.enums.Role;

public class LoginService {


    public Role checkPassword(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return Role.ADMIN;
        }else if (username.equals("user") && password.equals("user")) {
            return Role.USER;
        }


        return Role.NOT_LOGIN;
    }
}
