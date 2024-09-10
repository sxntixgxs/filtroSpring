package com.filtro.demo.proveedor.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.proveedor.domain.models.Supplier;
import com.filtro.demo.proveedor.domain.ports.in.SupplierOperations;
import com.filtro.demo.proveedor.domain.ports.out.SupplierRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class SupplierServices implements SupplierOperations{
    @Autowired
    private SupplierRepository repository;

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Optional<Supplier> updateSupplier(Supplier supplier) {
        return repository.findById(supplier.getId()).isPresent() ? Optional.of(repository.save(supplier)) : Optional.empty(); 
    }

    @Override
    public Optional<Supplier> getSupplierById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    @Override
    public boolean deleteSupplierById(Integer id) {
        Optional<Supplier> supplierExists =  repository.findById(id);
        if(supplierExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
