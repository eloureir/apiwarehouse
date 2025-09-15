package com.warehouse.apiwarehouse.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO,generator = "UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private String sku;
    @Column(nullable = false,updatable = false)
    private String name;


    @ManyToMany(mappedBy = "products")
    private Set<Shipment> shipments = new HashSet<>();
}
