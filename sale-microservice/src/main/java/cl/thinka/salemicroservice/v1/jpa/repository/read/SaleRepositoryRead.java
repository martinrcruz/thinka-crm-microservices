package cl.thinka.salemicroservice.v1.jpa.repository.read;

import cl.thinka.salemicroservice.v1.jpa.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SaleRepositoryRead extends JpaRepository<Sale, Long> {
    Sale getSaleById(Long id);

    List<Sale> findAll();
}
