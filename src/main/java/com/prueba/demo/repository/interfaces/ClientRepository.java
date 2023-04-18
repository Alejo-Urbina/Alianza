package com.prueba.demo.repository.interfaces;

import com.prueba.demo.dto.ClientResponse;
import com.prueba.demo.dto.InformationClient;
import com.prueba.demo.entity.ClientEntity;

import java.util.List;

public interface ClientRepository {

    ClientResponse saveClient(InformationClient informationClient);

    List<ClientEntity> getClients();

    InformationClient getClient(Integer id);

    InformationClient getClientSharedKey(String sharedKey);

}
