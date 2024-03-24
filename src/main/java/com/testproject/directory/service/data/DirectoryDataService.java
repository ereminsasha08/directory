package com.testproject.directory.service.data;

import com.testproject.directory.dto.DirectoryDataDto;

import java.util.Map;

public interface DirectoryDataService {
    DirectoryDataDto getDataByDirectoryId(Integer directoryId);

    DirectoryDataDto getDataById(Integer directoryId, Integer dataId);

    DirectoryDataDto insertData(Integer directoryId, Map<String, Object> data);

    void deleteDataById(Integer directoryId, Integer dataId);
}
