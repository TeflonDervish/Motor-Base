package org.example.motorbasejavafx.service;


import org.example.motorbasejavafx.enums.Roles;

public class LoginService {


    public Roles checkPassword(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return Roles.ADMIN;
        }else if (username.equals("user") && password.equals("user")) {
            return Roles.USER;
        }


        return Roles.NOT_LOGIN;
    }
}
