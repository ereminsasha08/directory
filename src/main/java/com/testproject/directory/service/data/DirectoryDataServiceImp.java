package com.testproject.directory.service.data;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.service.DirectoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectoryDataServiceImp implements DirectoryDataService {
    private final DataStrategyService dataStrategyService;
    private final DirectoryService directoryService;

    @Override
    public DirectoryDataDto getDataByDirectoryId(Integer directoryId) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        List<CatalogDataDto> dataForDirectory = dataRepository.findDataForDirectory(directory);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(dataForDirectory)
                .build();
    }

    @Override
    public DirectoryDataDto getDataById(Integer directoryId, Integer dataId) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        CatalogDataDto dataForDirectory = dataRepository.findDataForDirectoryById(directory, dataId);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(List.of(dataForDirectory))
                .build();
    }

    @Override
    @Transactional
    public DirectoryDataDto insertData(Integer directoryId, CatalogDataDto data) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        CatalogDataDto inserted = dataRepository.insertData(directory, data);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(List.of(inserted))
                .build();
    }

    @Override
    @Transactional
    public void deleteDataById(Integer directoryId, Integer id) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        dataRepository.deleteById(directory, id);
    }
}
