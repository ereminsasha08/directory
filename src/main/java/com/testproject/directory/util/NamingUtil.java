package com.testproject.directory.util;

import com.testproject.directory.entity.Attribute;
import com.testproject.directory.entity.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NamingUtil {
    private NamingUtil() {
    }

    public static String tableName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName();
    }

    public static String tableLinkName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName() + "_link";
    }

    public static ParameterForInsert parameterForInsert(Directory directory) {
        Set<Attribute> attributes = directory.getEntityType().getAttributes();
        StringBuilder result = new StringBuilder(" (");
        List<String> orderedParameter = new ArrayList<>();
        attributes.forEach(a -> {
            orderedParameter.add(a.getName());
            result.append(a.getName() + ",");
        });
        result.replace(result.length() - 1, result.length(), ") values (");
        result.append("?,".repeat(attributes.size()));
        result.replace(result.length() - 1, result.length(), ")");
        return ParameterForInsert.builder()
                .orderParameter(orderedParameter)
                .prepareForInsert(result.toString())
                .build();
    }
}
