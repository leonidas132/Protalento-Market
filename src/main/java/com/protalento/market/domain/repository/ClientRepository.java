package com.protalento.market.domain.repository;

import com.protalento.market.domain.Client;


import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();
    Optional<Client>getClient(String idClient);

    Client getSave(Client client);

    /*
    void delet(String id);
     */

}
