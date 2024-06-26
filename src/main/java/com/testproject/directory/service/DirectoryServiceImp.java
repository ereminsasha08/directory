package com.testproject.directory.service;

import com.testproject.directory.dto.DirectoryDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.entity.EntityType;
import com.testproject.directory.repository.DirectoryRepository;
import com.testproject.directory.repository.EntityTypeRepository;
import com.testproject.directory.service.structure.DirectoryStructureService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImp implements DirectoryService {
    private final DirectoryRepository repository;
    private final EntityTypeRepository entityTypeRepository;
    private final DirectoryStructureService directoryStructureService;

    @Override
    public List<Directory> getAll() {
        return repository.findAll();
    }

    @Override
    public Directory getById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found directory by id: " + id));
    }

    @Override
    public Directory getByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new RuntimeException("Not found directory by name: " + name));
    }

    @Override
    @Transactional
    public Directory create(DirectoryDto directory) {
        Optional<EntityType> findEntity = entityTypeRepository.findById(directory.getEntityTypeId());
        EntityType entityType = findEntity.orElseThrow(() -> new RuntimeException("NotFoundEntityType"));
        Directory created = repository.save(Directory.builder()
                .id(directory.getId())
                .name(directory.getName())
                .entityType(entityType)
                .structureType(directory.getStructureType())
                .build());
        directoryStructureService.createStructure(created);
        return created;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Directory directory = getById(id);
        directoryStructureService.deleteStructure(directory);
        repository.deleteById(id);
    }
}
