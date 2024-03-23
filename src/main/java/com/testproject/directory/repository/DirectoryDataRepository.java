package com.testproject.directory.repository;

import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryDataRepository {
    List<?> findDataForDirectory(Directory directory);
    void deleteById(Directory directory, Integer id);
}
