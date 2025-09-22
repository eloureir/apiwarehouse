package com.warehouse.apiwarehouse.service;

import com.warehouse.apiwarehouse.dto.SectionCreateDTO;
import com.warehouse.apiwarehouse.dto.WarehouseCreateDTO;
import com.warehouse.apiwarehouse.entity.Section;
import com.warehouse.apiwarehouse.entity.Warehouse;
import com.warehouse.apiwarehouse.repository.SectionRepository;
import com.warehouse.apiwarehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository repository;
    public WarehouseCreateDTO findById(UUID id) {
        Warehouse warehouse = repository.findById(id).orElseThrow();
        return convertToDto(warehouse);
    }

    public List<WarehouseCreateDTO> findAll() {
        List<Warehouse> warehouses = repository.findAll();
        List<WarehouseCreateDTO> warehouseDTO = new ArrayList<>();
        for (Warehouse warehouse : warehouses) {
            warehouseDTO.add(convertToDto(warehouse));
        }
        return warehouseDTO;

    }

    public WarehouseCreateDTO save(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse =  repository.save(warehouse);
        return convertToDto(warehouse);
    }

    public WarehouseCreateDTO update(UUID id, WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = convertToEntity(warehouseCreateDTO);
        warehouse.setId(id);
        warehouse = repository.save(warehouse);
        return convertToDto(warehouse);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
    public WarehouseCreateDTO convertToDto(Warehouse warehouse) {
        WarehouseCreateDTO warehouseCreateDTO = new WarehouseCreateDTO();
        warehouseCreateDTO.setName(warehouse.getName());
        return warehouseCreateDTO;
    }
    public Warehouse convertToEntity(WarehouseCreateDTO warehouseCreateDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseCreateDTO.getName());
        return warehouse;
    }
}
