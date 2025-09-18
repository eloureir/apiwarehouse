package com.warehouse.apiwarehouse.controller;

import com.warehouse.apiwarehouse.dto.ProductCreateDTO;
import com.warehouse.apiwarehouse.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private ProductService service;

    @GetMapping("/{id}")
    public ProductCreateDTO findById(@PathVariable("id") UUID id) {
        return service.findById(id);
    }
    @GetMapping
    public List<ProductCreateDTO> findAll() {
        return service.findAll();
    }
    @PostMapping
    public ProductCreateDTO save(
            @RequestBody ProductCreateDTO productCreateDTO) {
        return service.save(productCreateDTO);
    }
    @PutMapping("/{id}")
    public ProductCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody ProductCreateDTO productCreateDTO) {
        return service.update(id, productCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id) { service.deleteById(id);}
}
