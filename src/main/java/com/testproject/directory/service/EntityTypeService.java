package com.testproject.directory.service;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.EntityType;

import java.util.List;

public interface EntityTypeService {
    List<EntityType> getAll();

    EntityType getById(Integer id);

    EntityType getByName(String name);

    EntityType create(EntityType entityType);

    void deleteById(Integer id);

    EntityType addAttribute(Integer entityTypeId, Attribute attribute);
}
