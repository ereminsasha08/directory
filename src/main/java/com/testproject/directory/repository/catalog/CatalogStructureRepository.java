package com.testproject.directory.repository.catalog;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryStructureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogStructureRepository implements DirectoryStructureRepository {

    @Override
    public void createStructure(Directory directory) {

    }
}
