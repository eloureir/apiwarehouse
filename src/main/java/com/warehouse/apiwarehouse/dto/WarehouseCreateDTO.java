package com.warehouse.apiwarehouse.dto;

public class WarehouseCreateDTO {
    private String name;

    public WarehouseCreateDTO(String name) {
        this.name = name;
    }
    public WarehouseCreateDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
