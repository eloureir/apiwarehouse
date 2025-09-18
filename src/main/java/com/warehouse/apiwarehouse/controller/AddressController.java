package com.warehouse.apiwarehouse.controller;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private AddressService service;

    @GetMapping("/{id}")
    public AddressCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<AddressCreateDTO> findAll() {
        return service.findAll();
    }
    @PostMapping
    public AddressCreateDTO save(
            @RequestBody AddressCreateDTO addressCreateDTO) {
        return service.save(addressCreateDTO);
    }
    @PutMapping("/{id}")
    public AddressCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody AddressCreateDTO addressCreateDTO) {
        return service.update(id, addressCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id) { service.deleteById(id);}
}
