package org.example.motorbasejavafx.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersLogin {
    private String password;
    private String phone_number;
    private String email;
}
