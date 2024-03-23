package com.testproject.directory.service.structure;

import com.testproject.directory.entity.StructureType;
import com.testproject.directory.repository.DirectoryStructureRepository;

public interface StructureStrategyService {
    DirectoryStructureRepository getStructureRepository(StructureType structureType);
}
