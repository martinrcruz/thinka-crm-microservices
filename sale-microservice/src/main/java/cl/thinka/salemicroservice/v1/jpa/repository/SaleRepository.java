package cl.thinka.salemicroservice.v1.jpa.repository;

import cl.thinka.salemicroservice.v1.jpa.entity.Sale;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository {

    Sale save(Sale sale);

    boolean deleteById(Long id);

    Sale getById(Long id);

    List<Sale> getAll();

}
