package com.protalento.market.domain.repository;

import com.protalento.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll(); // obtiene todas las compras
    Optional<List<Purchase>> getByClient(String clientId); // retorna la lista de compra de un cliente
    Purchase save(Purchase purchase);
}