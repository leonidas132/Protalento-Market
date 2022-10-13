package com.protalento.market.persistences;

import com.protalento.market.domain.Client;
import com.protalento.market.domain.repository.ClientRepository;
import com.protalento.market.persistences.crud.ClientCrudRepository;
import com.protalento.market.persistences.entity.Cliente;
import com.protalento.market.persistences.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // CON ESTO LE ESTAMOS INDICANDO A SPRING QUE ESTO ES UN COMPONENTE DE UN BEAN Y QUE ESTA CLASE SE ENCARGA DE INTERECTUAR CON LA BASE DE DATOS
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        return clientMapper.toClients((List<Cliente>)clientCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getClient(String idClient) {
        return clientCrudRepository.findById(idClient).map(cliente -> clientMapper.toClient(cliente));
    }

    @Override
    public Client getSave(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clientCrudRepository.save(cliente));
    }


    /*
    @Overrid
    public void delet(String id) {
        clientCrudRepository.deleteById(id);
     }
     */



}
