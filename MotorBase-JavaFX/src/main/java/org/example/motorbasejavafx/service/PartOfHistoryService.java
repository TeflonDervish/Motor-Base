package org.example.motorbasejavafx.service;

import org.example.motorbasejavafx.model.PartOfHistory;
import org.example.motorbasejavafx.repository.PartOfHistoryRepository;

import java.io.IOException;
import java.util.List;

public class PartOfHistoryService {

    private PartOfHistoryRepository partOfHistoryRepository;

    public List<PartOfHistory> getAll() throws IOException, InterruptedException {
        return partOfHistoryRepository.getAll();
    }

    public PartOfHistory getById(Long id) throws IOException, InterruptedException {
        return partOfHistoryRepository.getById(id);
    }

    public PartOfHistory register(PartOfHistory PartOfHistory) throws IOException, InterruptedException {
        return partOfHistoryRepository.register(PartOfHistory);
    }

    public void deleteById(Long id) throws IOException, InterruptedException {
        partOfHistoryRepository.deleteById(id);
    }

    public PartOfHistory update(PartOfHistory PartOfHistory) throws IOException, InterruptedException {
        return partOfHistoryRepository.update(PartOfHistory);
    }
}
