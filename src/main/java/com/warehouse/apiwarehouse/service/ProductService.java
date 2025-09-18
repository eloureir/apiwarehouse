package com.warehouse.apiwarehouse.service;

import com.warehouse.apiwarehouse.dto.ProductCreateDTO;
import com.warehouse.apiwarehouse.entity.Product;
import com.warehouse.apiwarehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductCreateDTO findById(UUID id) {
        Product product = repository.findById(id).orElseThrow();
        return convertToDto(product);
    }

    public List<ProductCreateDTO> findAll() {
        List<Product> products = repository.findAll();
        List<ProductCreateDTO> productDTO = new ArrayList<>();
        for (Product product : products) {
            productDTO.add(convertToDto(product));
        }
        return productDTO;
    }

    public ProductCreateDTO save(ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product =  repository.save(product);
        return convertToDto(product);
    }

    public ProductCreateDTO update(UUID id, ProductCreateDTO productCreateDTO) {
        Product product = convertToEntity(productCreateDTO);
        product.setId(id);
        product = repository.save(product);
        return convertToDto(product);

    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
    public ProductCreateDTO convertToDto(Product product) {
        ProductCreateDTO productCreateDTO = new ProductCreateDTO();
        productCreateDTO.setName(product.getName());
        productCreateDTO.setSku(product.getSku());
        return productCreateDTO;
    }
    public Product convertToEntity(ProductCreateDTO productCreateDTO) {
        Product product = new Product();
        product.setName(productCreateDTO.getName());
        product.setSku(productCreateDTO.getSku());
        return product;
    }
}
