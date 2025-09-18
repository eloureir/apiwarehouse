package com.warehouse.apiwarehouse.repository;

import com.warehouse.apiwarehouse.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository
        extends JpaRepository<Address, UUID> {
}
