package com.testproject.directory.service.data;

import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.entity.Directory;

import java.util.Map;

public interface DirectoryDataService {
    DirectoryDataDto getDataByDirectoryId(Integer directoryId);

    DirectoryDataDto insertData(Integer directoryId, Map<String, Object> data);

    void deleteDataById(Directory directory, Integer id);
}
