package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class AnnouncementService {

    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAll() {
        return announcementRepository.findAll();
    }

    public Optional<Announcement> getById(Long id) {
        return announcementRepository.findById(id);
    }
}
