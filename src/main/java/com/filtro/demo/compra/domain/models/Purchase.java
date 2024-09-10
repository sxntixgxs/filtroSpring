package com.filtro.demo.compra.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filtro.demo.proveedor.domain.models.Supplier;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "compras")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String date;
    private Integer total;// COP is Z
    @ManyToOne
    @JoinColumn(name="supplier_id")
    // @JsonIgnore
    private Supplier supplier;
}
