package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.Announcement;
import org.example.motorbasejavafx.repository.AnnouncementRepository;
import org.example.motorbasejavafx.repository.AnnouncementRepository;

import java.io.IOException;
import java.util.List;

public class AnnouncementService {

    private AnnouncementRepository announcementRepository;

    public List<Announcement> getAll() throws IOException, InterruptedException {
        return announcementRepository.getAll();
    }

    public Announcement getById(Long id) throws IOException, InterruptedException {
        return announcementRepository.getById(id);
    }

    public Announcement register(Announcement Announcement) throws IOException, InterruptedException {
        return announcementRepository.register(Announcement);
    }

    public void deleteById(Long id) throws IOException, InterruptedException {
        announcementRepository.deleteById(id);
    }

    public Announcement update(Announcement Announcement) throws IOException, InterruptedException {
        return announcementRepository.update(Announcement);
    }
}
