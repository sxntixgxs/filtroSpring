package com.filtro.demo.compra.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.demo.compra.domain.models.Purchase;
import com.filtro.demo.compra.domain.ports.in.PurchaseOperations;
import com.filtro.demo.compra.domain.ports.out.PurchaseRepository;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class PurchaseServices implements PurchaseOperations{
    @Autowired
    private PurchaseRepository repository;

    @Override
    public Purchase createPurchase(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public Optional<Purchase> updatePurchase(Purchase purchase) {
        Optional<Purchase> purchaseExists = repository.findById(purchase.getId());
        if(purchaseExists.isPresent()){
            return Optional.of(repository.save(purchase));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Purchase> getPurchaseById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Purchase> getallPurchases() {
        return repository.findAll();
    }

    @Override
    public boolean deletePurchaseById(Integer id) {
        Optional<Purchase> purchaseExists = repository.findById(id);
        if(purchaseExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
