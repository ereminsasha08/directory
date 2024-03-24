package com.testproject.directory.entity;

import lombok.Getter;
import org.jooq.DataType;
import org.jooq.impl.SQLDataType;

public enum AttributeType {
    STRING(SQLDataType.VARCHAR),
    INTEGER(SQLDataType.INTEGER),
    DATE(SQLDataType.DATE);
    @Getter
    private DataType dataType;

    AttributeType(DataType dataType) {
        this.dataType = dataType;
    }
}
