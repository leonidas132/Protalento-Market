package com.protalento.market.persistences.mapper;

import com.protalento.market.domain.Client;
import com.protalento.market.persistences.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring",uses ={PurchaseMapper.class})
public interface ClientMapper {
    @Mappings({
            @Mapping(source = " id",target = "idClient"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "apellido",target = "lastName"),
            @Mapping(source = "celular",target = " phone"),
            @Mapping(source = "direccion",target = "addres"),
            @Mapping(source = "correoElectronico",target = "email"),
            @Mapping(source = "listCompras",target = "listPurchases"),
    })
    Client toClient (Cliente cliente);

    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    Cliente toCliente (Client client);
}
