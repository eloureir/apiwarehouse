package com.warehouse.apiwarehouse.repository;

import com.warehouse.apiwarehouse.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipmentRepository
        extends JpaRepository<Shipment, UUID> {
}
