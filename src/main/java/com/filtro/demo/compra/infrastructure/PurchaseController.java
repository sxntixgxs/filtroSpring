package com.filtro.demo.compra.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.demo.compra.application.PurchaseServices;
import com.filtro.demo.compra.domain.dto.PurchaseRequest;
import com.filtro.demo.compra.domain.models.Purchase;
import com.filtro.demo.proveedor.application.SupplierServices;
import com.filtro.demo.proveedor.domain.models.Supplier;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseServices services;
    @Autowired
    private SupplierServices supplierServices;
    @GetMapping
    public List<Purchase> getPurchases(){
        return services.getallPurchases();
    }
    @PostMapping
    public String createPurchase(@RequestBody PurchaseRequest purchase){
        Optional<Supplier> supplierExists = supplierServices.getSupplierById(purchase.getSupplier_id());
        if(supplierExists.isPresent()){
            Purchase createdPurchase = new Purchase();
            createdPurchase.setDate(purchase.getDate());
            createdPurchase.setSupplier(supplierExists.get());
            createdPurchase.setTotal(purchase.getTotal());
            services.createPurchase(createdPurchase);
            return "created";
        }else{
            return "supplier does not found";
        }
    }
    @PutMapping
    public String updatePurchase(@RequestBody Purchase purchase){
        Optional<Purchase> purchaseExists = services.getPurchaseById(purchase.getId());
        Optional<Supplier> supplierExists = supplierServices.getSupplierById(purchase.getSupplier().getId());
        if(purchaseExists.isPresent() && supplierExists.isPresent()){
            services.updatePurchase(purchase);
            return "updated";
        }else{
            return "cannot update";
        }
    }
    @DeleteMapping("/{id}")
    public String deletePurchase(@RequestParam Integer id){
        return services.deletePurchaseById(id) ? "deleted" : "not deleted";
    }
}
