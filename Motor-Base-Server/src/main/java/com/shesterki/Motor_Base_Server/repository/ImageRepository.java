package com.shesterki.Motor_Base_Server.repository;

import com.shesterki.Motor_Base_Server.model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
