package com.testproject.directory.service;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.EntityType;
import com.testproject.directory.repository.DirectoryRepository;
import com.testproject.directory.repository.EntityTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EntityTypeServiceImp implements EntityTypeService {
    private final EntityTypeRepository repository;
    private final DirectoryRepository directoryRepository;

    @Override
    public List<EntityType> getAll() {
        return repository.findAll();
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
    public EntityType create(EntityType entityType) {
        return repository.save(entityType);
    }

    @Override
    public void deleteById(Integer id) {
        if (directoryRepository.existsByEntityTypeId(id)) {
            throw new RuntimeException("Not allowed to delete entity with exist directory");
        }
        repository.deleteById(id);
    }

    @Override
    public EntityType addAttribute(Integer entityTypeId, Attribute attribute) {
        throw new UnsupportedOperationException();
    }
}
