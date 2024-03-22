package cl.thinka.clientmicroservice.v1.jpa.repository.read;

import cl.thinka.clientmicroservice.v1.jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepositoryRead extends JpaRepository<Client, Long> {
    Client getClientById(Long id);

    List<Client> findAll();
}
