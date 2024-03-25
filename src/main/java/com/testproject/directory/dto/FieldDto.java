package com.testproject.directory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldDto {
    private String name;
    private Object value;
}
