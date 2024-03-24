package com.testproject.directory.service;

import com.testproject.directory.dto.DirectoryDto;
import com.testproject.directory.entity.Directory;

import java.util.List;

public interface DirectoryService {
    List<Directory> getAll();

    Directory getById(Integer id);

    Directory getByName(String name);

    Directory create(DirectoryDto directory);

    void deleteById(Integer id);

}
