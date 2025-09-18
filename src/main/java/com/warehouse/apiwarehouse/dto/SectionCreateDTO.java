package com.warehouse.apiwarehouse.dto;

public class SectionCreateDTO {

    private String Code;

    public SectionCreateDTO(String code) {
        Code = code;
    }
    public SectionCreateDTO() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}

