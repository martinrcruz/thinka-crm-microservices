package cl.thinka.salemicroservice.v1.service.impl;

import cl.thinka.salemicroservice.v1.dto.SaleDTO;
import cl.thinka.salemicroservice.v1.dto.request.AddSaleRequestDTO;
import cl.thinka.salemicroservice.v1.dto.request.EditSaleRequestDTO;
import cl.thinka.salemicroservice.v1.jpa.entity.Sale;
import cl.thinka.salemicroservice.v1.jpa.repository.SaleRepository;
import cl.thinka.salemicroservice.v1.mapper.SaleMapper;
import cl.thinka.salemicroservice.v1.service.ISaleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class SaleServiceImpl implements ISaleService {

    @Autowired
    SaleRepository saleRepository;

    @Override
    public List<SaleDTO> listSales() throws Exception {
        try {
            List<SaleDTO> salesDTO = new ArrayList<>();
            List<Sale> sales = saleRepository.getAll();
            for (Sale sale : sales) {
                SaleDTO saleDTO = new SaleDTO();
                saleDTO = SaleMapper.INSTANCE.toDto(sale);
                salesDTO.add(saleDTO);
            }
            return salesDTO;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public SaleDTO getSaleById(Long id) throws Exception {
        SaleDTO response = new SaleDTO();
        try {
            Sale sale = saleRepository.getById(id);
            response = SaleMapper.INSTANCE.toDto(sale);
            return response;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return response;
        }
    }

    @Override
    public Boolean deleteSaleById(Long id) throws Exception {
        try {
            return this.saleRepository.deleteById(id);
        } catch (Exception e) {
            log.error(SaleServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public SaleDTO editSale(EditSaleRequestDTO sale) throws Exception {
        try {
            log.info(SaleServiceImpl.class + " SUCCESS ");
            Sale existingSale = this.saleRepository.getById(1L);

            if(existingSale != null){
                Sale newSale = SaleMapper.INSTANCE.toEntity(sale);
                return SaleMapper.INSTANCE.toDto(this.saleRepository.save(newSale));
            } else {
                log.error(SaleServiceImpl.class + "Error: Cannot create sale");
                return null;
            }
        } catch (Exception e) {
            log.error(SaleServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public SaleDTO saveSale(AddSaleRequestDTO sale) throws Exception {
        try {
            Sale newSale = SaleMapper.INSTANCE.toEntity(sale);
            log.info(SaleServiceImpl.class + " SUCCESS ");
            return SaleMapper.INSTANCE.toDto(this.saleRepository.save(newSale));
        } catch (Exception e) {
            log.error(SaleServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }
}
