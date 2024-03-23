package com.testproject.directory.service;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.entity.EntityType;

import java.util.List;

public interface EntityTypeService {
    List<EntityTypeService> getAll();
    EntityType getById(Integer id);
    EntityType getByName(String name);
    EntityType create(Directory directory);
    void deleteById(Integer id);
    EntityType addAttribute(Integer entityTypeId, Attribute attribute);
}
