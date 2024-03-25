package com.testproject.directory.service.data;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.dto.DirectoryDataDto;

public interface DirectoryDataService {
    DirectoryDataDto getDataByDirectoryId(Integer directoryId);

    DirectoryDataDto getDataById(Integer directoryId, Integer dataId);

    DirectoryDataDto insertData(Integer directoryId, CatalogDataDto data);

    void deleteDataById(Integer directoryId, Integer dataId);
}
