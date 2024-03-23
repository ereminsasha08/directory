package com.testproject.directory.controller;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.entity.EntityType;
import com.testproject.directory.service.EntityTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(EntityTypeController.URL)
@RequiredArgsConstructor
public class EntityTypeController {
    public static final String URL = "/api/v1/entity-type";
    private final EntityTypeService service;

    @GetMapping
    public List<EntityType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public EntityType getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/{name}")
    public EntityType getByName(String name) {
        return service.getByName(name);
    }

    @PostMapping("/save")
    public EntityType save(@RequestBody Directory directory) {
        return service.create(directory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PatchMapping("/{id}/add/attribute")
    public EntityType addAttribute(@PathVariable Integer entityTypeId, @RequestBody Attribute attribute) {
        return service.addAttribute(entityTypeId, attribute);
    }
}
