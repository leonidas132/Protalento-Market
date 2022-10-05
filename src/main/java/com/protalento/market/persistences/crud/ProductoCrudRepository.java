package com.protalento.market.persistences.crud;

import com.protalento.market.persistences.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    // querys methods


    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria); //lista de categoria

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado); //lista de productos escasos

    Optional<Producto> findByIdProductoAndAndIdCategoria (int id, int idCategoria);

}
