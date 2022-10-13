package com.protalento.market.persistences.crud;

import com.protalento.market.persistences.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCrudRepository extends CrudRepository<Cliente,String> {

    Optional<Cliente> findById(String idCliente);
}
