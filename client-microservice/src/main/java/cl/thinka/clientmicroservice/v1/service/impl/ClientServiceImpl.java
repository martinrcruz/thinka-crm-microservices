package cl.thinka.clientmicroservice.v1.service.impl;

import cl.thinka.clientmicroservice.v1.dto.ClientDTO;
import cl.thinka.clientmicroservice.v1.dto.request.AddClientRequestDTO;
import cl.thinka.clientmicroservice.v1.dto.request.EditClientRequestDTO;
import cl.thinka.clientmicroservice.v1.jpa.entity.Client;
import cl.thinka.clientmicroservice.v1.jpa.repository.ClientRepository;
import cl.thinka.clientmicroservice.v1.mapper.ClientMapper;
import cl.thinka.clientmicroservice.v1.service.IClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ClientServiceImpl implements IClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientDTO> listClients() throws Exception {
        try {
            List<ClientDTO> clientsDTO = new ArrayList<>();
            List<Client> clients = clientRepository.getAll();
            for (Client client : clients) {
                ClientDTO clientDTO = new ClientDTO();
                clientDTO = ClientMapper.INSTANCE.toDto(client);
                clientsDTO.add(clientDTO);
            }
            return clientsDTO;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ClientDTO getClientById(Long id) throws Exception {
        ClientDTO response = new ClientDTO();
        try {
            Client client = clientRepository.getById(id);
            response = ClientMapper.INSTANCE.toDto(client);
            return response;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return response;
        }
    }

    @Override
    public Boolean deleteClientById(Long id) throws Exception {
        try {
            return this.clientRepository.deleteById(id);
        } catch (Exception e) {
            log.error(ClientServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public ClientDTO editClient(EditClientRequestDTO client) throws Exception {
        try {
            log.info(ClientServiceImpl.class + " SUCCESS ");
            Client existingClient = this.clientRepository.getById(1L);

            if(existingClient != null){
                Client newClient = ClientMapper.INSTANCE.toEntity(client);
                return ClientMapper.INSTANCE.toDto(this.clientRepository.save(newClient));
            } else {
                log.error(ClientServiceImpl.class + "Error: Cannot create client");
                return null;
            }
        } catch (Exception e) {
            log.error(ClientServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public ClientDTO saveClient(AddClientRequestDTO client) throws Exception {
        try {
            Client newClient = ClientMapper.INSTANCE.toEntity(client);
            log.info(ClientServiceImpl.class + " SUCCESS ");
            return ClientMapper.INSTANCE.toDto(this.clientRepository.save(newClient));
        } catch (Exception e) {
            log.error(ClientServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }
}
