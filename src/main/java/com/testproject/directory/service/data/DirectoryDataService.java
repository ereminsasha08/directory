package com.testproject.directory.service.data;

public interface DirectoryDataService<T, R> {
    T getDataByDirectoryId(Integer directoryId);

    T getDataById(Integer directoryId, Integer dataId);

    T insertData(Integer directoryId, R data);

    void deleteDataById(Integer directoryId, Integer dataId);
}
