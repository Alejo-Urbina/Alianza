package com.prueba.demo.repository;

import com.prueba.demo.controller.ClientController;
import com.prueba.demo.dto.ClientResponse;
import com.prueba.demo.dto.InformationClient;
import com.prueba.demo.entity.ClientEntity;
import com.prueba.demo.repository.interfaces.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.ZoneId;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public ClientResponse saveClient(InformationClient informationClient) {
        LOGGER.info("El cliente ya ingreso al servicio rest guardar del repositorio");
        ClientEntity entity = new ClientEntity(null,informationClient.getSharedKey(),informationClient.getBusinessId(),
                informationClient.getEmail(),informationClient.getPhone(),informationClient.getStartDate(),
                informationClient.getEndDate());
        em.persist(entity);
        ClientResponse response = new ClientResponse();
        response.setId(entity.getID());
        response.setStartDate(informationClient.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return response;
    }

    @Override
    public List<ClientEntity> getClients() {
        LOGGER.info("El servicio rest consultar todos los clientes del repositorio");
        Query query = em.createQuery("SELECT c FROM client c");
        return (List<ClientEntity>) query.getResultList();
    }

    @Override
    public InformationClient getClient(Integer id) {
        LOGGER.info("El servicio rest consultar por id del repositorio");
        ClientEntity client = em.find(ClientEntity.class,id);
        return new InformationClient(
                client.getID(),
                client.getSHAREDKEY(),
                client.getBUSINESSID(),
                client.getEMAIL(),
                client.getPHONE(),
                client.getSTARTDATE(),
                client.getENDDATE()
        );
    }

    @Override
    public InformationClient getClientSharedKey(String sharedKey) {
        LOGGER.info("El servicio rest consultar por sharedKey del repositorio");
        Query q = em.createNativeQuery("SELECT * FROM client c WHERE SHAREDKEY = :sharedKey",ClientEntity.class);
        q.setParameter("sharedKey", sharedKey);
        ClientEntity client = (ClientEntity) q.getSingleResult();
        System.out.println(client);
        return new InformationClient(
                client.getID(),
                client.getSHAREDKEY(),
                client.getBUSINESSID(),
                client.getEMAIL(),
                client.getPHONE(),
                client.getSTARTDATE(),
                client.getENDDATE()
        );
    }
}
