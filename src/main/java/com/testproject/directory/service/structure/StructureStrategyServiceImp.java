package com.testproject.directory.service.structure;

import com.testproject.directory.entity.StructureType;
import com.testproject.directory.repository.DirectoryStructureRepository;
import com.testproject.directory.repository.catalog.CatalogStructureRepository;
import com.testproject.directory.repository.constant.ConstantStructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StructureStrategyServiceImp implements StructureStrategyService {
    private final CatalogStructureRepository catalogDataRepository;
    private final ConstantStructureRepository constantDataRepository;

    @Override
    public DirectoryStructureRepository getStructureRepository(StructureType structureType) {
        return switch (structureType) {
            case CATAlOG -> catalogDataRepository;
            case CONSTANT -> constantDataRepository;
            default -> throw new IllegalStateException("Unexpected value: " + structureType);
        };
    }
}
