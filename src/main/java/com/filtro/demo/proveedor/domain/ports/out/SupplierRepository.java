package com.filtro.demo.proveedor.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.proveedor.domain.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer>{

}
