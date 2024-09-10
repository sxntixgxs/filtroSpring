package com.filtro.demo.compra.domain.dto;

import lombok.Data;

@Data
public class PurchaseRequest {
    private String date;
    private Integer total;
    private Integer supplier_id;
}
