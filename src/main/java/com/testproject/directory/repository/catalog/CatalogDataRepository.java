package com.testproject.directory.repository.catalog;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.util.NamingUtil;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CatalogDataRepository implements DirectoryDataRepository {
    private final DSLContext dslContext;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> findDataForDirectory(Directory directory) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        String tableName = NamingUtil.tableName(directory);
        String sql = dslContext.select()
                .from(tableLinkName)
                .leftJoin(tableName).on(tableLinkName + ".id = " + tableName + ".id")
                .getSQL();
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> insertData(Directory directory, Map<String, Object> data) {
        return null;
    }

    @Override
    public void deleteById(Directory directory, Integer id) {

    }
}

