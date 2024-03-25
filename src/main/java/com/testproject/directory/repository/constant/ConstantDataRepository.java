package com.testproject.directory.repository.constant;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstantDataRepository implements DirectoryDataRepository {
    @Override
    public List<CatalogDataDto> findDataForDirectory(Directory directory) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public CatalogDataDto findDataForDirectoryById(Directory directory, Integer id) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public CatalogDataDto insertData(Directory directory, CatalogDataDto data) {
        throw new RuntimeException("Not supported");
    }

    @Override
    public void deleteById(Directory directory, Integer id) {
        throw new RuntimeException("Not supported");
    }
}
