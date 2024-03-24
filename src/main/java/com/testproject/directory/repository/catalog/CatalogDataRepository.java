package com.testproject.directory.repository.catalog;

import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.util.NamingUtil;
import com.testproject.directory.util.ParameterForInsert;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import static java.sql.PreparedStatement.*;

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
    public List<Map<String, Object>> findDataForDirectoryById(Directory directory, Integer dataId) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        String tableName = NamingUtil.tableName(directory);
        String sql = dslContext.select()
                .from(tableLinkName)
                .leftJoin(tableName).on(tableLinkName + ".id = " + tableName + ".id")
                .where(tableName + ".id = " + dataId)
                .getSQL();
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> insertData(Directory directory, Map<String, Object> data) {
        int id = insertIntoCatalog(directory, data);
        insertIntoLink(directory, data, id);
        return findDataForDirectoryById(directory, id);
    }


    private int insertIntoCatalog(Directory directory, Map<String, Object> data) {
        String tableName = NamingUtil.tableName(directory);
        ParameterForInsert parameterForInsert = NamingUtil.parameterForInsert(directory);
        String insertSql = "insert into " + tableName + parameterForInsert.getPrepareForInsert();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        List<String> orderParameter = parameterForInsert.getOrderParameter();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(insertSql, RETURN_GENERATED_KEYS);
            for (int i = 1; i <= orderParameter.size(); i++) {
                ps.setObject(i, data.get(orderParameter.get(i - 1)));
            }
            return ps;
        }, keyHolder);
        return (int) keyHolder.getKeyList().getFirst().get("id");
    }

    private void insertIntoLink(Directory directory, Map<String, Object> data, int id) {
        String linkName = NamingUtil.tableLinkName(directory);
        String s = "insert into " + linkName + " (id, parent_id, is_folder) values (?,?,?)";
        jdbcTemplate.update(s, ps -> {
            ps.setObject(1, id);
            ps.setObject(2, data.get("parentId"));
            ps.setObject(3, data.get("isFolder"));
        });
    }

    @Override
    public void deleteById(Directory directory, Integer id) {
        deleteLink(directory, id);
        deleteData(directory, id);
    }


    private void deleteLink(Directory directory, Integer id) {
        String linkName = NamingUtil.tableLinkName(directory);
        String delete = "delete from " + linkName + " where id = " + id;
        jdbcTemplate.update(delete);
    }

    private void deleteData(Directory directory, Integer id) {
        String catalogName = NamingUtil.tableName(directory);
        String delete = "delete from " + catalogName + " where id = " + id;
        jdbcTemplate.update(delete);
    }
}

