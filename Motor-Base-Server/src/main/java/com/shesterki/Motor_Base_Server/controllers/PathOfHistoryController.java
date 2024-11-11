package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.PartOfHistory;
import com.shesterki.Motor_Base_Server.services.PathOfHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pathOfHistory")
@AllArgsConstructor
public class PathOfHistoryController {

    private PathOfHistoryService pathOfHistoryService;

    @GetMapping("/getAll")
    private List<PartOfHistory> getAll() {
        return pathOfHistoryService.getAll();
    }

    @GetMapping("/get/{id}")
    private Optional<PartOfHistory> getById(@PathVariable Long id){
        return pathOfHistoryService.getById(id);
    }
}
