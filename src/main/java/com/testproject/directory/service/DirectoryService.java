package com.testproject.directory.service;

import com.testproject.directory.dto.DirectoryData;
import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryService {
    List<Directory> getAll();
    Directory getById(Integer id);
    Directory getByName(String name);
    Directory create(Directory directory);
    void deleteById(Integer id);
    DirectoryData getDataByDirectoryId(Integer directoryId);
}
