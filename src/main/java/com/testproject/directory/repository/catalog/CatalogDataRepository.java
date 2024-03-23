package com.testproject.directory.repository.catalog;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;

import java.util.List;

public class CatalogDataRepository implements DirectoryDataRepository {
    @Override
    public List<?> findDataForDirectory(Directory directory) {
        return null;
    }

    @Override
    public void deleteById(Directory directory, Integer id) {

    }
}
