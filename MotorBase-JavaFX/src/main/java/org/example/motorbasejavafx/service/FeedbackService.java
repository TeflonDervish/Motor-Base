package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.Feedback;
import org.example.motorbasejavafx.repository.FeedbackRepository;

import java.io.IOException;
import java.util.List;

public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAll() throws IOException, InterruptedException {
        return feedbackRepository.getAll();
    }

    public Feedback getById(Long id) throws IOException, InterruptedException {
        return feedbackRepository.getById(id);
    }

    public Feedback register(Feedback Feedback) throws IOException, InterruptedException {
        return feedbackRepository.register(Feedback);
    }

    public void deleteById(Long id) throws IOException, InterruptedException {
        feedbackRepository.deleteById(id);
    }

    public Feedback update(Feedback Feedback) throws IOException, InterruptedException {
        return feedbackRepository.update(Feedback);
    }
}
