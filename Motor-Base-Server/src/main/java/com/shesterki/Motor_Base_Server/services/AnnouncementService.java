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

    public Announcement postAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public void deleteById(Long id) {
        announcementRepository.deleteById(id);
    }

    public Announcement updateAnnouncement(Announcement newAnnouncement) {
        Announcement announcement = announcementRepository.findById(newAnnouncement.getId()).orElseThrow();
        announcement.setName(newAnnouncement.getName());
        announcement.setPrice(newAnnouncement.getPrice());
        announcement.setDescription(newAnnouncement.getDescription());

        return announcementRepository.save(announcement);
    }

    public List<Announcement> getByUserId(Long userId) {
        return announcementRepository.findByUserId(userId);
    }

    public List<Announcement> getBySearch(String text) {
        return announcementRepository.findByNameContaining(text);
    }
}
