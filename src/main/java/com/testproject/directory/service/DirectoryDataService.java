package com.testproject.directory.service;

import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryDataService {
    void createStructure(Directory directory);
    List<?> getDataForDirectory(Directory directory);
    void deleteDataById(Directory directory, Integer id);
}
