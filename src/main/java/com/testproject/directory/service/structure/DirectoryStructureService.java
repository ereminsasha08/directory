package com.testproject.directory.service.structure;

import com.testproject.directory.entity.Directory;

public interface DirectoryStructureService {
    void createStructure(Directory directory);

    void deleteStructure(Directory directory);
}
