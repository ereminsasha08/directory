package com.testproject.directory.repository.constant;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryStructureRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConstantStructureRepository implements DirectoryStructureRepository {
    @Override
    public void createStructure(Directory directory) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void deleteStructure(Directory directory) {
        throw new RuntimeException("Not supported");
    }
}
