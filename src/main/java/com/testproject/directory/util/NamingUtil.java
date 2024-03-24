package com.testproject.directory.util;

import com.testproject.directory.entity.Directory;

public class NamingUtil {
    private NamingUtil() {
    }

    public static String tableName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName();
    }

    public static String tableLinkName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName() + "_link";
    }
}
