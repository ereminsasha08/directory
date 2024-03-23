package com.testproject.directory.controller;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.entity.EntityType;
import com.testproject.directory.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(DirectoryController.URL)
@RequiredArgsConstructor
public class DirectoryController {
    public static final String URL = "/api/v1/directories";
    private final DirectoryService service;

    @GetMapping
    public List<Directory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Directory getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/{name}")
    public Directory getByName(String name) {
        return service.getByName(name);
    }

    @PostMapping("/save")
    public Directory save(@RequestBody Directory directory) {
        return service.create(directory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
