package cl.thinka.salemicroservice.v1.jpa.repository.impl;

import cl.thinka.salemicroservice.v1.jpa.repository.SaleRepository;
import cl.thinka.salemicroservice.v1.jpa.repository.read.SaleRepositoryRead;
import cl.thinka.salemicroservice.v1.jpa.repository.write.SaleRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository {
    @Autowired
    SaleRepositoryRead saleRepositoryRead;
    @Autowired
    SaleRepositoryWrite saleRepositoryWrite;

    @Override
    public cl.thinka.salemicroservice.v1.jpa.entity.Sale save(cl.thinka.salemicroservice.v1.jpa.entity.Sale sale) {
        return saleRepositoryWrite.save(sale);
    }

    @Override
    public boolean deleteById(Long id) {
        saleRepositoryWrite.deleteById(id);
        return false;
    }

    @Override
    public cl.thinka.salemicroservice.v1.jpa.entity.Sale getById(Long id) {
        return saleRepositoryRead.getSaleById(id);
    }

    @Override
    public List<cl.thinka.salemicroservice.v1.jpa.entity.Sale> getAll() {
        return saleRepositoryRead.findAll();
    }
}
