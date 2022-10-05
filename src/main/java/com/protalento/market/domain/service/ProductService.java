package com.protalento.market.domain.service;

import com.protalento.market.domain.Product;
import com.protalento.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*esta  clase service funciona como
* un intermedario entre el controlador y la capa de negocio*/


@Service // es un servicio de nuestra logica de negosio
public class ProductService {
    // se inyecta el productRepository
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll(); // todos los productos
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProducto(productId);
    }

    public Optional<List<Product>> getBYCategory(int category){
        return productRepository.getBycategoria(category);
    }

    public Product getSave (Product product){
        return productRepository.getSave(product);
    }

    public boolean getEliminar(int productId){
       if(getProduct(productId).isPresent()){
           productRepository.getEliminar(productId);
           return true;
       }else {
           return false;
       }
    }

    public Optional<Product> getIdProductAndIdC(int idP, int idC){
        return productRepository.getIdProductoAndIdCategoria(idP,idC);
    }

}
