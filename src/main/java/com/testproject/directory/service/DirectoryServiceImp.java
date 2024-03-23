package com.testproject.directory.service;

import com.testproject.directory.dto.DirectoryData;
import com.testproject.directory.entity.Directory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DirectoryServiceImp implements DirectoryService{
    @Override
    public List<Directory> getAll() {
        return null;
    }

    @Override
    public Directory getById(Integer id) {
        return null;
    }

    @Override
    public Directory getByName(String name) {
        return null;
    }

    @Override
    public Directory create(Directory directory) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public DirectoryData getDataByDirectoryId(Integer directoryId) {
        return null;
    }
}
