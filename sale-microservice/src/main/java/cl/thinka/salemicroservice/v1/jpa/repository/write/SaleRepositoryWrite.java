package cl.thinka.salemicroservice.v1.jpa.repository.write;

import cl.thinka.salemicroservice.v1.jpa.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepositoryWrite extends JpaRepository<Sale, Long> {

    void deleteById(Long id);

}
