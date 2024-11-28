package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.repository.AnnouncementRepository;
import com.shesterki.Motor_Base_Server.repository.CarRepository;
import com.shesterki.Motor_Base_Server.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Data
@AllArgsConstructor
public class UsersService {

    private UsersRepository userRepository;

    private AnnouncementRepository announcementRepository;

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

    public Users updateUser(Users newUser) {
        Users user = userRepository.findById(newUser.getId()).orElseThrow();
        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setPhoneNumber(newUser.getPhoneNumber());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setUserRole(newUser.getUserRole());
        return userRepository.save(user);
    }

    public void AddFavoriteAnnouncement(Long userId, Long announcementId) {
        Users user = userRepository.findById(userId).orElseThrow();
        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow();
        user.getFavoriteAnnouncement().add(announcement);
        userRepository.save(user);
    }

    public Set<Announcement> getFavoriteAnnouncement(Long id) {
        Users user = userRepository.findById(id).orElseThrow();
        return user.getFavoriteAnnouncement();
    }
}
