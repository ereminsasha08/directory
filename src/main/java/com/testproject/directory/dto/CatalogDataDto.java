package com.testproject.directory.dto;

import com.testproject.directory.entity.Directory;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class CatalogDataDto {
    private CatalogLink catalogLink;
    private List<FieldDto> fields;

    public CatalogDataDto(Directory directory, Map<String, Object> map) {
        this.catalogLink = new CatalogLink((Integer) map.get("id"), (Integer) map.get("parent_id"), (boolean) map.get("is_folder"));
        this.fields = directory.getEntityType().getAttributes().stream().map(a -> new FieldDto(a.getName(), map.get(a.getName()))).toList();
    }
}
