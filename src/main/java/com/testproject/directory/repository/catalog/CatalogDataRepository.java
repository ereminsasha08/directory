package com.testproject.directory.repository.catalog;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.dto.CatalogLink;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryDataRepository;
import com.testproject.directory.util.NamingUtil;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.sql.PreparedStatement.RETURN_GENERATED_KEYS;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Repository
@RequiredArgsConstructor
public class CatalogDataRepository implements DirectoryDataRepository<CatalogDataDto> {
    private final DSLContext dslContext;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CatalogDataDto> findDataForDirectory(Directory directory) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        String tableName = NamingUtil.tableName(directory);
        String sql = dslContext.select()
                .from(tableLinkName)
                .leftJoin(tableName).on(tableLinkName + ".id = " + tableName + ".id")
                .getSQL();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps.stream().map(map -> new CatalogDataDto(directory, map)).toList();
    }

    @Override
    public CatalogDataDto findDataForDirectoryById(Directory directory, Integer dataId) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        String tableName = NamingUtil.tableName(directory);
        String sql = dslContext.select()
                .from(tableLinkName)
                .leftJoin(tableName).on(tableLinkName + ".id = " + tableName + ".id")
                .where(tableName + ".id = " + dataId)
                .getSQL();
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        return new CatalogDataDto(directory, map);

    }

    @Override
    public CatalogDataDto insertData(Directory directory, CatalogDataDto data) {
        int id = insertIntoCatalog(directory, data);
        insertIntoLink(directory, data.getCatalogLink(), id);
        return findDataForDirectoryById(directory, id);
    }


    private int insertIntoCatalog(Directory directory, CatalogDataDto data) {
        String tableName = NamingUtil.tableName(directory);
        List<Field<?>> names = new ArrayList<>();
        List<Field<Object>> values = new ArrayList<>();
        data.getFields().forEach(a -> {
            names.add(field(a.getName()));
            values.add(field(a.getValue().toString()));
        });
        String insert = dslContext.insertInto(table(tableName), names).values(values).getSQL();
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> connection.prepareStatement(insert, RETURN_GENERATED_KEYS), keyHolder);
        return (int) keyHolder.getKeyList().getFirst().get("id");
    }

    private void insertIntoLink(Directory directory, CatalogLink catalogLink, Integer id) {
        String linkName = NamingUtil.tableLinkName(directory);
        String insert = dslContext
                .insertInto(table(linkName), field("id"), field("parent_id"), field("is_folder"))
                .values(field(id.toString()), field(catalogLink.getParentId().toString()), field(catalogLink.getIsFolder().toString()))
                .getSQL();
        jdbcTemplate.update(insert);
    }

    @Override
    public void deleteById(Directory directory, Integer id) {
        deleteLink(directory, id);
        deleteData(directory, id);
    }


    private void deleteLink(Directory directory, Integer id) {
        String linkName = NamingUtil.tableLinkName(directory);
        String delete = dslContext.delete(table(linkName))
                .where(field("id").eq(field(id.toString())))
                .getSQL();
        jdbcTemplate.update(delete);
    }

    private void deleteData(Directory directory, Integer id) {
        String catalogName = NamingUtil.tableName(directory);
        String delete = dslContext.delete(table(catalogName))
                .where(field("id").eq(field(id.toString())))
                .getSQL();
        jdbcTemplate.update(delete);
    }
}

