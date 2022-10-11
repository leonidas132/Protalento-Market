package com.protalento.market.persistences.crud;

import com.protalento.market.persistences.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra,Integer>{
  Optional<List<Compra>> findByIdCliente(String idCliente);
}
