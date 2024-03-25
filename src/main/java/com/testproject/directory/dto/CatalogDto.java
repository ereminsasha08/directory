package com.testproject.directory.dto;

import com.testproject.directory.entity.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CatalogDto {
    Directory directory;
    List<CatalogDataDto> data;
}
