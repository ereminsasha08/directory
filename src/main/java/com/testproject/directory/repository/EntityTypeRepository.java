package com.testproject.directory.repository;

import com.testproject.directory.entity.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityTypeRepository extends JpaRepository<EntityType, Integer> {
}
