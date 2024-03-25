package com.testproject.directory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CatalogLink {
    private Integer id;
    private Integer parentId;
    private Boolean isFolder;
}
