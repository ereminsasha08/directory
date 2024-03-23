package com.testproject.directory.service;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.entity.EntityType;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntityTypeServiceImp implements EntityTypeService {
    @Override
    public List<EntityType> getAll() {
        return null;
    }

    @Override
    public EntityType getById(Integer id) {
        return null;
    }

    @Override
    public EntityType getByName(String name) {
        return null;
    }

    @Override
    public EntityType create(Directory directory) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public EntityType addAttribute(Integer entityTypeId, Attribute attribute) {
        throw new UnsupportedOperationException();
    }
}
