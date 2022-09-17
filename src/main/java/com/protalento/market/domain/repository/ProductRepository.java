package com.protalento.market.domain.repository;

import com.protalento.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    //le indica a todos los repositorios como se deben de comportar cunado esten hablando de producto

    // se indica el nombre de los metodos que queremos que cualquier repositorio tenga que implemtar

    List<Product>getAll();
    Optional<List<Product>> getBycategoria(int categoryId);//lista de producto y su categoria
    Optional<List<Product>> getProductScasos(int quentity); // productos escasos
    Optional<Product> getProducto(int productId); //retorna un producto
    Product getSave(Product product);
    void getEliminar(int productId);

}
