package com.filtro.demo.sales.domain.dto;

import lombok.Data;

@Data
public class SalesRequest {
    private String date;
    private Integer customer_id;
}
