package com.prueba.demo.service;

import com.prueba.demo.controller.ClientController;
import com.prueba.demo.dto.ClientRequest;
import com.prueba.demo.dto.ClientResponse;
import com.prueba.demo.dto.InformationClient;
import com.prueba.demo.entity.ClientEntity;
import com.prueba.demo.repository.interfaces.ClientRepository;
import com.prueba.demo.service.interfaces.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientResponse saveClient(ClientRequest clientRequest) {
        InformationClient informationClient = new InformationClient();
        informationClient.setSharedKey(clientRequest.getSharedKey());
        informationClient.setBusinessId(clientRequest.getBusinessId());
        informationClient.setEmail(clientRequest.getEmail());
        informationClient.setPhone(clientRequest.getPhone());
        informationClient.setStartDate(clientRequest.getStartDate());
        informationClient.setEndDate(clientRequest.getEndDate());
        LOGGER.info("El cliente ya ingreso al servicio rest guardar del service");
        return this.clientRepository.saveClient(informationClient);
    }

    @Override
    public List<ClientEntity> getClients() {
        LOGGER.info("El servicio rest consultar todos los clientes del service");
        return this.clientRepository.getClients();
    }

    @Override
    public InformationClient getClient(Integer id) {
        LOGGER.info("El servicio rest consultar por id del service");
        return this.clientRepository.getClient(id);
    }

    @Override
    public InformationClient getClientSharedKey(String sharedKey) {
        LOGGER.info("El servicio rest consultar por sharedKey del service");
        return this.clientRepository.getClientSharedKey(sharedKey);
    }
}
