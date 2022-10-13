package com.protalento.market.persistences.crud;

import com.protalento.market.persistences.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Categoria,String> {
}
