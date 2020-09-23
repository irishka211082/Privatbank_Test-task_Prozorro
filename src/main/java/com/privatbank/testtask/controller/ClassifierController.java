package com.privatbank.testtask.controller;

import com.privatbank.testtask.domain.ClassifierItem;
import com.privatbank.testtask.service.ClassifierService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/classifier")
public class ClassifierController {
    private final ClassifierService classifierService;

    public ClassifierController(ClassifierService classifierService) {
        this.classifierService = classifierService;
    }

    @PostMapping
    public ResponseEntity<List<ClassifierItem>> addItems() {
        return new ResponseEntity<>(classifierService.saveAllItemsToDb(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassifierItem> getItem(@PathVariable @NonNull String id) {
        return new ResponseEntity<>(classifierService.getItemById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/children")
    public ResponseEntity<List<ClassifierItem>> getItemChildren(@PathVariable @NonNull String id) {
        return new ResponseEntity<>(classifierService.getChildren(id), HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<ClassifierItem>> getAllItems() {
        return new ResponseEntity<>(classifierService.getAllRecords(), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<List<ClassifierItem>> updateItems() {
        return new ResponseEntity<>(classifierService.updateRecords(), HttpStatus.OK);
    }
}

