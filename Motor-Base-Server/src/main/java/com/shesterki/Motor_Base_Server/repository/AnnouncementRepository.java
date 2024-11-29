package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Announcement> findByUserId(Long userId);
    List<Announcement> findByNameContaining(String name);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE mark = :mark)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarMark(@Param("mark") String mark);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE model = :model)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarModel(@Param("model") String model);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE year_make = :yearMake)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarYearMake(@Param("yearMake") Integer yearMake);

    @Query(value = "SELECT * FROM Announcement WHERE price between :from and :to", nativeQuery = true)
    Set<Announcement> findAnnouncementsByPrice(@Param("from") Integer from,
                                                @Param("to") Integer to);

    @Query(value = "SELECT * FROM Announcement WHERE car_id in " +
            "(SELECT id FROM Car WHERE run between :from and :to)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarRun(@Param("from") Integer from,
                                                @Param("to") Integer to);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE engine_volume = :engineVolume)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarEngineVolume(@Param("engineVolume") Double engineVolume);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE engine_powers = :enginePowers)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarEnginePowers(@Param("enginePowers") Double enginePowers);

    // Тип кузова
    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE type_body = :typeBody)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarTypeBody(@Param("typeBody") String typeBody);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE gearbox = :gearbox)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarGearbox(@Param("gearbox") String gearbox);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE type = :type)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarType(@Param("type") String type);

    @Query(value = "SELECT * FROM Announcement WHERE car_id IN " +
            "(SELECT id FROM Car WHERE color = :color)", nativeQuery = true)
    Set<Announcement> findAnnouncementsByCarColor(@Param("color") String color);




}
