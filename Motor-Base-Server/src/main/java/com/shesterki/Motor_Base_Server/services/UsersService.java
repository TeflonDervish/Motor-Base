package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UsersService {

    private UsersRepository userRepository;

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public Optional<Users> getById(Long id) {
        return userRepository.findById(id);
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Users updateUser(Users user) {
        return userRepository.save(user);
    }
}
