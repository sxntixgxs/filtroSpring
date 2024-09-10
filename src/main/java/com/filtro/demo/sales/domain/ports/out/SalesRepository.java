package com.filtro.demo.sales.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.sales.domain.models.Sales;

public interface SalesRepository extends JpaRepository<Sales,Integer>{
    
}
