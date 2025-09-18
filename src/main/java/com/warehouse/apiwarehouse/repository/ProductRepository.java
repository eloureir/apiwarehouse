package com.warehouse.apiwarehouse.repository;

import com.warehouse.apiwarehouse.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository
        extends JpaRepository<Product, UUID> {
}
