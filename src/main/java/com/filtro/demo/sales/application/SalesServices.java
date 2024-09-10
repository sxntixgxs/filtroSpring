package com.filtro.demo.sales.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.filtro.demo.sales.domain.models.Sales;
import com.filtro.demo.sales.domain.ports.in.SalesOperations;
import com.filtro.demo.sales.domain.ports.out.SalesRepository;

public class SalesServices implements SalesOperations{
    @Autowired
    private SalesRepository repository;

    @Override
    public Sales createSales(Sales sales) {
        return repository.save(sales);
    }

    @Override
    public Optional<Sales> updateSales(Sales sales) {
        Optional<Sales> salesExists = repository.findById(sales.getId());
        if(salesExists.isPresent()){
            return Optional.of(repository.save(sales));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Sales> getSalesById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Sales> getAllSales() {
        return repository.findAll();
    }

    @Override
    public boolean deleteSalesById(Integer id) {
        Optional<Sales> salesExists = repository.findById(id);
        if(salesExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
