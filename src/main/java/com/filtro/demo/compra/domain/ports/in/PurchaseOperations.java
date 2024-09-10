package com.filtro.demo.compra.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.filtro.demo.compra.domain.models.Purchase;

public interface PurchaseOperations {
    Purchase createPurchase(Purchase purchase);
    Optional<Purchase> updatePurchase(Purchase purchase);
    Optional<Purchase> getPurchaseById(Integer id);
    List<Purchase> getallPurchases();
    boolean deletePurchaseById(Integer id);
}
