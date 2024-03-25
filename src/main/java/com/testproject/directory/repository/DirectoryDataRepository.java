package com.testproject.directory.repository;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryDataRepository {
    List<CatalogDataDto> findDataForDirectory(Directory directory);

    CatalogDataDto findDataForDirectoryById(Directory directory, Integer id);

    CatalogDataDto insertData(Directory directory, CatalogDataDto data);

    void deleteById(Directory directory, Integer id);
}
