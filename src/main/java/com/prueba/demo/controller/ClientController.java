package com.prueba.demo.controller;

import com.prueba.demo.dto.ClientRequest;
import com.prueba.demo.dto.ClientResponse;
import com.prueba.demo.dto.InformationClient;
import com.prueba.demo.entity.ClientEntity;
import com.prueba.demo.service.interfaces.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping()
    public final ClientResponse saveClient(@RequestBody ClientRequest clientRequest){
        LOGGER.info("El cliente ya ingreso al servicio rest guardar del controlador");
        return this.clientService.saveClient(clientRequest);
    }

    @GetMapping()
    public final List<ClientEntity> getClients(){
        LOGGER.info("El servicio rest consultar todos los clientes del controlador");
        return this.clientService.getClients();
    }

    @GetMapping("/{id}")
    public final InformationClient getClient(@PathVariable("id") Integer id){
        LOGGER.info("El servicio rest consultar por id del controlador");
        return this.clientService.getClient(id);
    }

    @GetMapping("/shared/{shared-key}")
    public final InformationClient getClientSharedKey(@PathVariable("shared-key") String sharedKey){
        LOGGER.info("El servicio rest consultar por sharedKey del controlador");
        return this.clientService.getClientSharedKey(sharedKey);
    }



}
