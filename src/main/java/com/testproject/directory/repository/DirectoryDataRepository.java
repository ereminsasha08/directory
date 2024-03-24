package com.testproject.directory.repository;

import com.testproject.directory.entity.Directory;

import java.util.List;
import java.util.Map;

public interface DirectoryDataRepository {
    List<Map<String, Object>> findDataForDirectory(Directory directory);

    List<Map<String, Object>> findDataForDirectoryById(Directory directory, Integer id);

    List<Map<String, Object>> insertData(Directory directory, Map<String, Object> data);

    void deleteById(Directory directory, Integer id);
}
