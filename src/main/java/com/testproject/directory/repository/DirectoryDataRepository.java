package com.testproject.directory.repository;

import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryDataRepository<T> {
    List<T> findDataForDirectory(Directory directory);

    T findDataForDirectoryById(Directory directory, Integer id);

    T insertData(Directory directory, T data);

    void deleteById(Directory directory, Integer id);
}
