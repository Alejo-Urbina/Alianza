package com.prueba.demo.service.interfaces;


import com.prueba.demo.dto.ClientRequest;
import com.prueba.demo.dto.ClientResponse;
import com.prueba.demo.dto.InformationClient;
import com.prueba.demo.entity.ClientEntity;

import java.util.List;

public interface ClientService {

    ClientResponse saveClient(ClientRequest clientRequest);

    List<ClientEntity> getClients();

    InformationClient getClient(Integer id);

    InformationClient getClientSharedKey(String sharedKey);

}
