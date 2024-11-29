package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Announcement;
import com.shesterki.Motor_Base_Server.repository.AnnouncementRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
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

    public Set<Announcement> getByFilter(
            String mark,
            String model,
            Integer yearMake,
            Integer priceFrom, Integer priceTo,
            Integer runFrom, Integer runTo,
            Double engineVolume,
            Double enginePowers,
            List<String> typeBody,
            String gearbox,
            String type,
            String color
    ) {
        Set<Announcement> announcements = new HashSet<>(announcementRepository.findAll());

        if (!mark.equals("null")) announcements.retainAll(announcementRepository.findAnnouncementsByCarMark(mark));

        if (!model.isEmpty()) announcements.retainAll(announcementRepository.findAnnouncementsByCarModel(mark));

        if (yearMake != null) announcements.retainAll(announcementRepository.findAnnouncementsByCarYearMake(yearMake));

        if (priceFrom != null && priceTo != null)
            announcements.retainAll(announcementRepository.findAnnouncementsByPrice(priceFrom, priceTo));

        if (runFrom != null && runTo != null)
            announcements.retainAll(announcementRepository.findAnnouncementsByCarRun(runFrom, runTo));

        if (engineVolume != null)
            announcements.retainAll(announcementRepository.findAnnouncementsByCarEngineVolume(engineVolume));

        if (enginePowers != null)
            announcements.retainAll(announcementRepository.findAnnouncementsByCarEnginePowers(enginePowers));

        if (typeBody != null)
            for (String s : typeBody)
                announcements.retainAll(announcementRepository.findAnnouncementsByCarTypeBody(s));

        if (!gearbox.equals("null")) announcements.retainAll(announcementRepository.findAnnouncementsByCarGearbox(gearbox));

        if (!type.equals("null")) announcements.retainAll(announcementRepository.findAnnouncementsByCarType(type));

        if (!color.isEmpty()) announcements.retainAll(announcementRepository.findAnnouncementsByCarColor(color));

        return announcements;


    }

}
