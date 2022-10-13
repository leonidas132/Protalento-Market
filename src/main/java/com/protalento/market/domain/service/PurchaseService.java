package com.protalento.market.domain.service;

import com.protalento.market.domain.Purchase;
import com.protalento.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service// es un servicio de nuestra logica de negosio
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
      return purchaseRepository.getAll(); //todas las compras
    }

    public Optional<List<Purchase>> ListComprasCliente(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save( Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    public Optional<Purchase> getPurchas(int idP){
        return purchaseRepository.getPurchase(idP);    }
    public boolean getDelete (int id){
        if(getPurchas(id).isPresent()){
            return purchaseRepository.delete(id);
        }else{
            return false;
        }
    }
}
