package com.testproject.directory.service.data;

import com.testproject.directory.entity.StructureType;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.repository.catalog.CatalogDataRepository;
import com.testproject.directory.repository.constant.ConstantDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataStrategyServiceImp implements DataStrategyService {
    private final CatalogDataRepository catalogDataRepository;
    private final ConstantDataRepository constantDataRepository;

    @Override
    public DirectoryDataRepository getDataRepository(StructureType structureType) {
        return switch (structureType) {
            case CATAlOG -> catalogDataRepository;
            case CONSTANT -> constantDataRepository;
            default -> throw new IllegalStateException("Unexpected value: " + structureType);
        };
    }
}
