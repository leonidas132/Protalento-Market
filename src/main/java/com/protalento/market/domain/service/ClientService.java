package com.protalento.market.domain.service;

import com.protalento.market.domain.Client;
import com.protalento.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getCliente(String idClient) {
        return clientRepository.getClient(idClient);
    }
    public Client getSave(Client client){
        return clientRepository.getSave(client);
    }
/*
    public boolean getEliminar(String id){
        if(getCliente(id).isPresent()){
            clientRepository.delet(id);
            return true;
        }else{
            return false;
        }
    }*/
}
