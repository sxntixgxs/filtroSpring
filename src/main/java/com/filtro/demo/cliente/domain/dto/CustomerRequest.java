package com.filtro.demo.cliente.domain.dto;

import lombok.Data;

@Data
public class CustomerRequest {
    private String name;
    private String email;
    private String phone;
    private String passsword;
    private Integer city_id;
}
