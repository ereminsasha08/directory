package com.testproject.directory.service.data;

import com.testproject.directory.entity.StructureType;
import com.testproject.directory.repository.DirectoryDataRepository;

public interface DataStrategyService {
    DirectoryDataRepository getDataRepository(StructureType structureType);
}
