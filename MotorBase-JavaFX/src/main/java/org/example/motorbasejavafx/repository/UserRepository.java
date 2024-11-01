package org.example.motorbasejavafx.repository;

import org.example.motorbasejavafx.model.User;

import java.net.http.HttpRequest;



public class UserRepository {


    HttpRequest httpRequest;


    public User getUser(Long id) {
        return new User();
    }

}
