package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.Users;
import org.example.motorbasejavafx.repository.UsersRepository;

import java.io.IOException;
import java.util.List;

public class UserService {

    private UsersRepository usersRepository;

    public List<Users> getAll() throws IOException, InterruptedException {
        return usersRepository.getAll();
    }

    public Users getById(Long id) throws IOException, InterruptedException {
        return usersRepository.getById(id);
    }

    public Users register(Users users) throws IOException, InterruptedException {
        return usersRepository.register(users);
    }

    public void deleteById(Long id) throws IOException, InterruptedException {
        usersRepository.deleteById(id);
    }

    public Users update(Users users) throws IOException, InterruptedException {
        return usersRepository.update(users);
    }

}
