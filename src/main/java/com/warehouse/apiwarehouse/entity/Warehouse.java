package com.warehouse.apiwarehouse.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO,generator = "UUID")
    @Column(nullable = false,updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Section>  sections = new HashSet<>();

}
