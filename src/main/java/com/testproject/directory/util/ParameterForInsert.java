package com.testproject.directory.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ParameterForInsert {
    List<String> orderParameter;
    String prepareForInsert;
}
