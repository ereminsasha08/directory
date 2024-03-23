package com.testproject.directory.dto;

import com.testproject.directory.entity.StructureType;
import lombok.Data;

@Data
public class DirectoryDto {
    private Integer id;
    private String name;
    private Integer entityTypeId;
    private StructureType structureType;
}
