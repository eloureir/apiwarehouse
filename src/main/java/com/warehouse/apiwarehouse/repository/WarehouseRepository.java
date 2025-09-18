package com.warehouse.apiwarehouse.repository;

import com.warehouse.apiwarehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository
        extends JpaRepository<Warehouse, UUID> {
}
