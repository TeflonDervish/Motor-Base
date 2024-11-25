package com.shesterki.Motor_Base_Server.exceptions;

public class UsersNotFoundException extends RuntimeException{

    public UsersNotFoundException(String message) {
        super(message);
    }
}
