package cl.thinka.clientmicroservice.v1.service;

import cl.thinka.clientmicroservice.v1.dto.ClientDTO;
import cl.thinka.clientmicroservice.v1.dto.request.AddClientRequestDTO;
import cl.thinka.clientmicroservice.v1.dto.request.EditClientRequestDTO;
import java.util.List;

public interface IClientService {

    public List<ClientDTO> listClients() throws Exception;
    public ClientDTO getClientById(Long id) throws Exception;
    public Boolean deleteClientById(Long id) throws Exception;
    public ClientDTO editClient(EditClientRequestDTO client) throws Exception;
    public ClientDTO saveClient(AddClientRequestDTO client) throws Exception;
}
