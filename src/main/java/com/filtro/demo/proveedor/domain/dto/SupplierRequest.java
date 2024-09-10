package com.filtro.demo.proveedor.domain.dto;

import lombok.Data;

@Data
public class SupplierRequest {
    private String name;
    private String contact;
    private String email;
    private Integer city_id;
}
