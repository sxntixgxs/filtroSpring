package com.filtro.demo.proveedor.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.proveedor.domain.models.Supplier;

public interface SupplierOperations {
    Supplier createSupplier(Supplier supplier);
    Optional<Supplier> updateSupplier(Supplier supplier);
    Optional<Supplier> getSupplierById(Integer id);
    List<Supplier> getAllSuppliers();
    boolean deleteSupplierById(Integer id);
}
