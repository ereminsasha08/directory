package com.testproject.directory.util;

import com.testproject.directory.entity.Directory;

public class TableUtil {
    private TableUtil() {
    }

    public static String getName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName();
    }

    public static String getLinkName(Directory directory) {
        return directory.getStructureType().toString().toLowerCase() + "_" + directory.getName() + "_" + directory.getEntityType().getName() + "_link";
    }
}
