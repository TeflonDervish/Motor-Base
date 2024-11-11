package org.example.motorbasejavafx.service;

import lombok.Data;
import org.example.motorbasejavafx.model.UserInformation;
import org.example.motorbasejavafx.model.UsersLogin;


@Data
public class CurrentUserService {

    private UsersLogin usersLogin;
    private UserInformation userInformation;

    public CurrentUserService() {
        usersLogin = new UsersLogin();
        userInformation = new UserInformation();
    }

}
