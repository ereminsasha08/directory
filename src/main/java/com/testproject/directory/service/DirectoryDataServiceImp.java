package com.testproject.directory.service;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.repository.DirectoryStructureRepository;
import com.testproject.directory.service.data.DataStrategyService;
import com.testproject.directory.service.structure.StructureStrategyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectoryDataServiceImp implements DirectoryDataService {
    private final StructureStrategyService strategyService;
    private final DataStrategyService dataStrategyService;

    @Override
    public void createStructure(Directory directory) {
        DirectoryStructureRepository structureRepository = strategyService.getStructureRepository(directory.getStructureType());
        structureRepository.createStructure(directory);
    }

    @Override
    public List<?> getDataForDirectory(Directory directory) {
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        return dataRepository.findDataForDirectory(directory);
    }

    @Override
    public void deleteDataById(Directory directory, Integer id) {
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        dataRepository.deleteById(directory, id);
    }
}
