package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.UserLogin;
import com.shesterki.Motor_Base_Server.repository.UserLoginRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UserLoginService {

    private UserLoginRepository userLoginRepository;

    public List<UserLogin> getAll() {
        return userLoginRepository.findAll();
    }

    public Optional<UserLogin> getById(Long id) {
        return userLoginRepository.findById(id);
    }

}
