package com.filtro.demo.compra.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.demo.compra.domain.models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{

}
