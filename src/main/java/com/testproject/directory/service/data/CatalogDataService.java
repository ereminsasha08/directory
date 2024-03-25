package com.testproject.directory.service.data;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.dto.CatalogDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.catalog.CatalogDataRepository;
import com.testproject.directory.service.DirectoryDataService;
import com.testproject.directory.service.DirectoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogDataService implements DirectoryDataService<CatalogDto, CatalogDataDto> {
    private final CatalogDataRepository catalogDataRepository;
    private final DirectoryService directoryService;

    @Override
    public CatalogDto getDataByDirectoryId(Integer directoryId) {
        Directory directory = directoryService.getById(directoryId);
        List<CatalogDataDto> dataForDirectory = catalogDataRepository.findDataForDirectory(directory);
        return CatalogDto.builder()
                .directory(directory)
                .data(dataForDirectory)
                .build();
    }

    @Override
    public CatalogDto getDataById(Integer directoryId, Integer dataId) {
        Directory directory = directoryService.getById(directoryId);
        CatalogDataDto dataForDirectory = catalogDataRepository.findDataForDirectoryById(directory, dataId);
        return CatalogDto.builder()
                .directory(directory)
                .data(List.of(dataForDirectory))
                .build();
    }

    @Override
    @Transactional
    public CatalogDto insertData(Integer directoryId, CatalogDataDto data) {
        Directory directory = directoryService.getById(directoryId);
        CatalogDataDto inserted = catalogDataRepository.insertData(directory, data);
        return CatalogDto.builder()
                .directory(directory)
                .data(List.of(inserted))
                .build();
    }

    @Override
    @Transactional
    public void deleteDataById(Integer directoryId, Integer id) {
        Directory directory = directoryService.getById(directoryId);
        catalogDataRepository.deleteById(directory, id);
    }
}
