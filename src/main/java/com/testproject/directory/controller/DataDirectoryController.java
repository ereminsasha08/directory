package com.testproject.directory.controller;

import com.testproject.directory.dto.DirectoryDataDto;
import com.testproject.directory.service.data.DirectoryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/directories/data")
@RequiredArgsConstructor
public class DataDirectoryController {
    private final DirectoryDataService directoryDataService;

    @GetMapping("/{id}")
    public DirectoryDataDto getById(@PathVariable Integer id) {
        return directoryDataService.getDataByDirectoryId(id);
    }
}
