package com.warehouse.apiwarehouse.controller;

import com.warehouse.apiwarehouse.dto.AddressCreateDTO;
import com.warehouse.apiwarehouse.dto.SectionCreateDTO;
import com.warehouse.apiwarehouse.service.AddressService;
import com.warehouse.apiwarehouse.service.SectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {
    private SectionService service;

    @GetMapping("/{id}")
    public SectionCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<SectionCreateDTO> findAll() {
        return service.findAll();
    }
    @PostMapping
    public SectionCreateDTO save(
            @RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.save(sectionCreateDTO);
    }
    @PutMapping("/{id}")
    public SectionCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody SectionCreateDTO sectionCreateDTO) {
        return service.update(id, sectionCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id) { service.deleteById(id);}
}
