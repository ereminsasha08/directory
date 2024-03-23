package com.testproject.directory.repository;

import com.testproject.directory.entity.Directory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectoryRepository extends JpaRepository<Directory, Integer> {
    Optional<Directory> findByName(String name);
    boolean existsByEntityTypeId(Integer entityTypeId);
}
