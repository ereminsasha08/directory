package com.testproject.directory.repository.constant;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ConstantDataRepository implements DirectoryDataRepository {
    @Override
    public List<Map<String, Object>> findDataForDirectory(Directory directory) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public List<Map<String, Object>> insertData(Directory directory, Map<String, Object> data) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void deleteById(Directory directory, Integer id) {
        throw new RuntimeException("Not supported");
    }
}
