package com.warehouse.apiwarehouse.controller;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.dto.WarehouseCreateDTO;
import com.warehouse.apiwarehouse.service.AddressService;
import com.warehouse.apiwarehouse.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    private WarehouseService service;

    @GetMapping("/{id}")
    public WarehouseCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<WarehouseCreateDTO> findAll() {
        return service.findAll();
    }
    @PostMapping
    public WarehouseCreateDTO save(
            @RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.save(warehouseCreateDTO);
    }
    @PutMapping("/{id}")
    public WarehouseCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody WarehouseCreateDTO warehouseCreateDTO) {
        return service.update(id, warehouseCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id) { service.deleteById(id);}
}
