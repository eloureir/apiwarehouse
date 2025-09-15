package com.warehouse.apiwarehouse.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @Column(nullable = false,updatable = false)
    private UUID id;
    @Column(nullable = false,updatable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;
}
