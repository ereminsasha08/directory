package com.testproject.directory.controller;

import com.testproject.directory.dto.CatalogDataDto;
import com.testproject.directory.dto.CatalogDto;
import com.testproject.directory.service.data.CatalogDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/catalog/data")
@RequiredArgsConstructor
public class CatalogDataController {
    private final CatalogDataService service;

    @GetMapping("/{catalogId}")
    public CatalogDto getById(@PathVariable Integer catalogId) {
        return service.getDataByDirectoryId(catalogId);
    }

    @GetMapping("/{catalogId}/{dataId}")
    public CatalogDto getDataById(@PathVariable Integer catalogId, @PathVariable Integer dataId) {
        return service.getDataById(catalogId, dataId);
    }

    @PostMapping("/{catalogId}")
    public CatalogDto insertData(@PathVariable Integer catalogId, @RequestBody CatalogDataDto data) {
        return service.insertData(catalogId, data);
    }

    @DeleteMapping("/{catalogId}/{dataId}")
    @ResponseStatus(OK)
    public void getById(@PathVariable Integer catalogId, @PathVariable Integer dataId) {
        service.deleteDataById(catalogId, dataId);
    }
}
