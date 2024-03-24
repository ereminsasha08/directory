package com.testproject.directory.dto;

import com.testproject.directory.entity.Directory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class DirectoryDataDto {
    Directory directory;
    List<Map<String, Object>> data;
}
