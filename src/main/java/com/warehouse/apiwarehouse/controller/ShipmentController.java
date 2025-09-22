package com.warehouse.apiwarehouse.controller;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.dto.ShipmentCreateDTO;
import com.warehouse.apiwarehouse.service.AddressService;
import com.warehouse.apiwarehouse.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shipment")
public class ShipmentController {
    private ShipmentService service;

    @GetMapping("/{id}")
    public ShipmentCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ShipmentCreateDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ShipmentCreateDTO save(
            @RequestBody ShipmentCreateDTO shipmentCreateDTO) {
        return service.save(shipmentCreateDTO);
    }

    @PutMapping("/{id}")
    public ShipmentCreateDTO update(
            @PathVariable("id") UUID id,
            @RequestBody ShipmentCreateDTO shipmentCreateDTO) {
        return service.update(id, shipmentCreateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
