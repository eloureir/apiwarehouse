package com.warehouse.apiwarehouse.repository;

import com.warehouse.apiwarehouse.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SectionRepository
        extends JpaRepository<Section, UUID> {
}
