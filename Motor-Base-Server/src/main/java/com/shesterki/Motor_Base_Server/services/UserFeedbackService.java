package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.UserFeedback;
import com.shesterki.Motor_Base_Server.repository.UserFeedbackRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UserFeedbackService {

    private UserFeedbackRepository feedbackRepository;

    public List<UserFeedback> getAll() {
        return feedbackRepository.findAll();
    }

    public Optional<UserFeedback> getById(Long id) {
        return feedbackRepository.findById(id);
    }

    public UserFeedback postFeedback(UserFeedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

    public UserFeedback updateFeedback(UserFeedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
