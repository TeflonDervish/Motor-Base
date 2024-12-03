package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.model.Car;
import com.shesterki.Motor_Base_Server.model.Users;
import com.shesterki.Motor_Base_Server.repository.AnnouncementRepository;
import com.shesterki.Motor_Base_Server.repository.CarRepository;
import com.shesterki.Motor_Base_Server.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Slf4j
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
        user.setImage(newUser.getImage());
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

    public Set<Users> getByFilter(
            String name,
            String surname,
            String phone,
            String email,
            String city,
            LocalDate birthday
    ){
        Set<Users> users = new HashSet<>(userRepository.findAll());

        System.out.println(
                name + " " +
                surname + " " +
                phone + " " +
                        email + " " +
                        city  + " " +
                        birthday
        );
        if (!name.isEmpty()) users.retainAll(userRepository.findByName(name));
        log.info(String.valueOf(users.size()));

        if (!surname.isEmpty()) users.retainAll(userRepository.findBySurname(surname));

        if (!phone.isEmpty()) users.retainAll(userRepository.findByPhoneNumber(phone));

        if (!email.isEmpty()) users.retainAll(new HashSet<>(Collections.singleton(userRepository.findByEmail(email))));

        if (!city.isEmpty()) users.retainAll(userRepository.findByCity(city));

        if (birthday != null) users.retainAll(userRepository.findByBirthday(birthday));
        log.info(String.valueOf(users.size()));

        return users;
    }

}
