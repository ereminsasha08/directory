package com.testproject.directory.controller;

import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.service.data.DirectoryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/directories/data")
@RequiredArgsConstructor
public class DataDirectoryController {
    private final DirectoryDataService directoryDataService;

    @GetMapping("/{id}")
    public DirectoryDataDto getById(@PathVariable Integer id) {
        return directoryDataService.getDataByDirectoryId(id);
    }

    @DeleteMapping("/{catalogId}/{dataId}")
    @ResponseStatus(OK)
    public void getById(@PathVariable Integer catalogId, @PathVariable Integer dataId) {
        directoryDataService.deleteDataById(catalogId, dataId);
    }
}
