package cl.thinka.clientmicroservice.v1.jpa.repository.write;

import cl.thinka.clientmicroservice.v1.jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryWrite extends JpaRepository<Client, Long> {

    void deleteById(Long id);

}
