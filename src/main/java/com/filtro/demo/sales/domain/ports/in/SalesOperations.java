package com.filtro.demo.sales.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.sales.domain.models.Sales;

public interface SalesOperations {
    Sales createSales(Sales sales);
    Optional<Sales> updateSales(Sales sales);
    Optional<Sales> getSalesById(Integer id);
    List<Sales> getAllSales();
    boolean deleteSalesById(Integer id);
}
