package com.shesterki.Motor_Base_Server.services;


import com.shesterki.Motor_Base_Server.model.PartOfHistory;
import com.shesterki.Motor_Base_Server.repository.PartOfHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class PathOfHistoryService {

    private PartOfHistoryRepository partOfHistoryRepository;

    public List<PartOfHistory> getAll() {
        return partOfHistoryRepository.findAll();
    }

    public Optional<PartOfHistory> getById(Long id) {
        return partOfHistoryRepository.findById(id);
    }
}
