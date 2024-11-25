package com.shesterki.Motor_Base_Server.controllers;

import com.shesterki.Motor_Base_Server.model.PartOfHistory;
import com.shesterki.Motor_Base_Server.services.PathOfHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pathOfHistory")
@AllArgsConstructor
public class PathOfHistoryController {

    private PathOfHistoryService pathOfHistoryService;

    @GetMapping("/getAll")
    private ResponseEntity<List<PartOfHistory>> getAll() {
        return new ResponseEntity<>(pathOfHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Optional<PartOfHistory>> getById(@PathVariable Long id){
        return new ResponseEntity<>(pathOfHistoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/post")
    private ResponseEntity<PartOfHistory> postPartOfHistory(@RequestBody PartOfHistory partOfHistory) {
        return new ResponseEntity<>(pathOfHistoryService.postPartOfHistory(partOfHistory), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<Void> deleteById(@PathVariable Long id){
        pathOfHistoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    private ResponseEntity<PartOfHistory> updatePartOfHistory(@RequestBody PartOfHistory partOfHistory) {
        return new ResponseEntity<>(pathOfHistoryService.updatePartOfHistory(partOfHistory), HttpStatus.OK);
    }
}
