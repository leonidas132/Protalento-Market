package com.protalento.market.persistences;

import com.protalento.market.domain.Purchase;
import com.protalento.market.domain.repository.PurchaseRepository;
import com.protalento.market.persistences.crud.CompraCrudRepository;
import com.protalento.market.persistences.crud.ProductoCrudRepository;
import com.protalento.market.persistences.entity.Compra;
import com.protalento.market.persistences.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // CON ESTO LE ESTAMOS INDICANDO A SPRING QUE ESTO ES UN COMPONENTE DE UN BEAN Y QUE ESTA CLASE SE ENCARGA DE INTERECTUAR CON LA BASE DE DATOS
public class CompraRerpository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;


    @Qualifier("purchaseMapperImpl")
    @Autowired
    private PurchaseMapper Mapper;


    @Override
    public List<Purchase> getAll() {
        return Mapper.toPurchases((List<Compra>)compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map( compras -> Mapper.toPurchases(compras));
        // resibe una lisat de compras y lo combiete a una lista de purchase
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = Mapper.toCompra(purchase);
        compra.getListar().forEach(producto-> producto.setCompra(compra));
        return  Mapper.toPurchase(compraCrudRepository.save(compra));
    }

    @Override
    public Optional<Purchase> getPurchase(int idPurchase) {
        return compraCrudRepository.findByIdCompra(idPurchase).map(compra -> Mapper.toPurchase(compra));
    }


    @Override
    public boolean delete(int purchaseID) {
        return compraCrudRepository.existsById(purchaseID);
    }
}
