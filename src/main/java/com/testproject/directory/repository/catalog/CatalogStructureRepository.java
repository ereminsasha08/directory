package com.testproject.directory.repository.catalog;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;
import com.testproject.directory.repository.DirectoryStructureRepository;
import com.testproject.directory.util.NamingUtil;
import lombok.RequiredArgsConstructor;
import org.jooq.CreateTableElementListStep;
import org.jooq.DSLContext;
import org.jooq.impl.SQLDataType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CatalogStructureRepository implements DirectoryStructureRepository {
    private final DSLContext dslContext;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void createStructure(Directory directory) {
        createCatalog(directory);
        createLink(directory);
    }


    private void createCatalog(Directory directory) {
        String tableName = NamingUtil.tableName(directory);
        CreateTableElementListStep table = dslContext.dsl().createTableIfNotExists(tableName);
        table.column("id", SQLDataType.INTEGER.identity(true));
        for (Attribute attribute
                : directory.getEntityType().getAttributes()) {
            table.column(attribute.getName(), attribute.getType().getDataType());
        }
        String catalog = table.getSQL();
        String id_index = dslContext.createIndexIfNotExists(tableName + "_id_idx").on(tableName, "id").getSQL();
        jdbcTemplate.update(catalog);
        jdbcTemplate.update(id_index);
    }

    private void createLink(Directory directory) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        CreateTableElementListStep table = dslContext.dsl().createTableIfNotExists(tableLinkName);
        String catalog_link = table
                .column("id", SQLDataType.INTEGER.nullable(false))
                .column("parent_id", SQLDataType.INTEGER.nullable(false))
                .column("is_folder", SQLDataType.BOOLEAN.nullable(false))
                .getSQL();
        String id_index = dslContext.createIndexIfNotExists(tableLinkName + "_id_idx").on(tableLinkName, "id").getSQL();
        String parent_id_index = dslContext.createIndexIfNotExists(tableLinkName + "_parent_id_idx").on(tableLinkName, "parent_id").getSQL();
        jdbcTemplate.update(catalog_link);
        jdbcTemplate.update(id_index);
        jdbcTemplate.update(parent_id_index);
    }


    @Override
    public void deleteStructure(Directory directory) {
        dropLink(directory);
        dropCatalog(directory);
    }

    private void dropLink(Directory directory) {
        String tableLinkName = NamingUtil.tableLinkName(directory);
        String dropLink = dslContext.dropTableIfExists(tableLinkName).getSQL();
        jdbcTemplate.update(dropLink);
    }

    private void dropCatalog(Directory directory) {
        String tableName = NamingUtil.tableName(directory);
        String dropTable = dslContext.dropTableIfExists(tableName).getSQL();
        jdbcTemplate.update(dropTable);
    }
}
