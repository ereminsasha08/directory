package com.testproject.directory.service.data;

import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.service.DirectoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DirectoryDataServiceImp implements DirectoryDataService {
    private final DataStrategyService dataStrategyService;
    private final DirectoryService directoryService;

    @Override
    public DirectoryDataDto getDataByDirectoryId(Integer directoryId) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        List<Map<String, Object>> dataForDirectory = dataRepository.findDataForDirectory(directory);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(dataForDirectory)
                .build();
    }

    @Override
    public DirectoryDataDto getDataById(Integer directoryId, Integer dataId) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        List<Map<String, Object>> dataForDirectory = dataRepository.findDataForDirectoryById(directory, dataId);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(dataForDirectory)
                .build();
    }

    @Override
    @Transactional
    public DirectoryDataDto insertData(Integer directoryId, Map<String, Object> data) {
        Directory directory = directoryService.getById(directoryId);
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        List<Map<String, Object>> inserted = dataRepository.insertData(directory, data);
        return DirectoryDataDto.builder()
                .directory(directory)
                .data(inserted)
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
