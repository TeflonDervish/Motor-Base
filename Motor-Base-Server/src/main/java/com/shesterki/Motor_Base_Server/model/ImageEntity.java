package com.shesterki.Motor_Base_Server.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] imageData;
}
