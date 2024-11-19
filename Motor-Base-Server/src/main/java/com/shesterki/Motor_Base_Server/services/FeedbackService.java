package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.Feedback;
import com.shesterki.Motor_Base_Server.repository.FeedbackRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback postFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

    public Feedback updateFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }
}
