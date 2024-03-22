package cl.thinka.salemicroservice.v1.service;

import cl.thinka.salemicroservice.v1.dto.SaleDTO;
import cl.thinka.salemicroservice.v1.dto.request.AddSaleRequestDTO;
import cl.thinka.salemicroservice.v1.dto.request.EditSaleRequestDTO;

import java.util.List;

public interface ISaleService {

    public List<SaleDTO> listSales() throws Exception;
    public SaleDTO getSaleById(Long id) throws Exception;
    public Boolean deleteSaleById(Long id) throws Exception;
    public SaleDTO editSale(EditSaleRequestDTO client) throws Exception;
    public SaleDTO saveSale(AddSaleRequestDTO client) throws Exception;
}
