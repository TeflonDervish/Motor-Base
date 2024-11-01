package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.UserInofrmation;
import com.shesterki.Motor_Base_Server.repository.UserInformationRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UserInformationService {

    private UserInformationRepository userInformationRepository;

    public List<UserInofrmation> getAll() {
        return userInformationRepository.findAll();
    }

    public Optional<UserInofrmation> getById(Long id) {
        return userInformationRepository.findById(id);
    }
}
