package com.protalento.market.persistences.crud;

import com.protalento.market.persistences.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryCrudRepository extends CrudRepository<Categoria,Integer> {

    Optional<Categoria> findByIdCategoria(int id);


}
