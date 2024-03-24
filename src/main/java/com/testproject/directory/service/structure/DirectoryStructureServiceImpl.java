package com.testproject.directory.service.structure;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryStructureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectoryStructureServiceImpl implements DirectoryStructureService {
    private final StructureStrategyService strategyService;

    @Override
    public void createStructure(Directory directory) {
        DirectoryStructureRepository structureRepository = strategyService.getStructureRepository(directory.getStructureType());
        structureRepository.createStructure(directory);
    }

    @Override
    public void deleteStructure(Directory directory) {
        DirectoryStructureRepository structureRepository = strategyService.getStructureRepository(directory.getStructureType());
        structureRepository.deleteStructure(directory);
    }
}
