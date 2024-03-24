package com.testproject.directory.service.data;

import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.service.DirectoryService;
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
    public DirectoryDataDto insertData(Integer directoryId, Map<String, Object> data) {
        return null;
    }

    @Override
    public void deleteDataById(Directory directory, Integer id) {
        DirectoryDataRepository dataRepository = dataStrategyService.getDataRepository(directory.getStructureType());
        dataRepository.deleteById(directory, id);
    }
}
