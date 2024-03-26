package com.testproject.directory.repository.constant;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstantDataRepository implements DirectoryDataRepository<Object> {
    @Override
    public List<Object> findDataForDirectory(Directory directory) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public List<Object> findDataForDirectoryById(Directory directory, Integer id) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public List<Object> insertData(Directory directory, Object data) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void deleteById(Directory directory, Integer id) {
        throw new RuntimeException("Not supported");
    }
}
