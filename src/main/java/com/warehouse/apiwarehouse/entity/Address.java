package com.warehouse.apiwarehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO,generator = "UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private String street;
    @Column(nullable = false,updatable = false)
    private String city;

    @OneToOne(mappedBy = "adress")
    private Warehouse warehouse;

}
