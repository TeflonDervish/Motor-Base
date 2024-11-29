package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.ImageEntity;
import com.shesterki.Motor_Base_Server.repository.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class ImageService {

    private ImageRepository imageRepository;

    public ImageEntity saveImage(ImageEntity image) {
        return imageRepository.save(image);
    }


}
