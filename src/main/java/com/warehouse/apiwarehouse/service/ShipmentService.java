package com.warehouse.apiwarehouse.service;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.dto.ShipmentCreateDTO;
import com.warehouse.apiwarehouse.entity.Address;
import com.warehouse.apiwarehouse.entity.Product;
import com.warehouse.apiwarehouse.entity.Shipment;
import com.warehouse.apiwarehouse.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository repository;

    public ShipmentCreateDTO findById(UUID id) {
        Shipment shipment = repository.findById(id).orElseThrow();
        return convertToDto(shipment);
    }

    public List<ShipmentCreateDTO> findAll() {
        List<Shipment> shipments = repository.findAll();
        List<ShipmentCreateDTO> shipmentDTO = new ArrayList<>();
        for (Shipment shipment : shipments) {
            shipmentDTO.add(convertToDto(shipment));
        }
        return shipmentDTO;
    }

    public ShipmentCreateDTO save(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment = repository.save(shipment);
        return convertToDto(shipment);
    }

    public ShipmentCreateDTO update(UUID id, ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = convertToEntity(shipmentCreateDTO);
        shipment.setId(id);
        shipment = repository.save(shipment);
        return convertToDto(shipment);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public ShipmentCreateDTO convertToDto(Shipment shipment) {
        ShipmentCreateDTO shipmentCreateDTO = new ShipmentCreateDTO();
        shipmentCreateDTO.setStatus(shipment.getStatus());
        return shipmentCreateDTO;
    }
    public Shipment convertToEntity(ShipmentCreateDTO shipmentCreateDTO) {
        Shipment shipment = new Shipment();
        shipment.setStatus(shipmentCreateDTO.getStatus());
        return shipment;
    }
}
