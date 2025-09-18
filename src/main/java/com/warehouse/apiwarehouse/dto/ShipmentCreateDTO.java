package com.warehouse.apiwarehouse.dto;

public class ShipmentCreateDTO {
    private String status;

    public ShipmentCreateDTO(String status) {
        this.status = status;
    }
    public ShipmentCreateDTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
