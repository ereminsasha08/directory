package com.testproject.directory.repository.constant;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryStructureRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstantStructureRepository implements DirectoryStructureRepository {
    @Override
    public void createStructure(Directory object) {

    }
}
