package cl.thinka.salemicroservice.v1.controller;

import cl.thinka.salemicroservice.v1.dto.SaleDTO;
import cl.thinka.salemicroservice.v1.dto.request.AddSaleRequestDTO;
import cl.thinka.salemicroservice.v1.dto.request.EditSaleRequestDTO;
import cl.thinka.salemicroservice.v1.service.impl.SaleServiceImpl;
import cl.thinka.salemicroservice.v1.enums.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.thinka.salemicroservice.v1.util.CustomResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/sale")
@Log4j2
public class SaleController {

    @Autowired
    private SaleServiceImpl saleService;

    @Operation(summary = "List all active sales")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/list")
    public CustomResponse listSales() throws Exception {
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " ****** New requested function ****** ");
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " Starting listSales ... ");
        try {
            List<SaleDTO> responseDTO = this.saleService.listSales();
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Get a sale by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/get/{id}")
    public CustomResponse getSaleById(@PathVariable Long id) throws Exception {
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " ****** New requested function ****** ");
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " Starting getSaleById ... ");
        try {
            SaleDTO responseDTO = this.saleService.getSaleById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Create a new Sale")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PostMapping(value = "/add")
    public CustomResponse addSale(@RequestBody AddSaleRequestDTO sale) throws Exception {
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " ****** New requested function ****** ");
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " Starting addSale ... ");
        try {
            return new CustomResponse(this.saleService.saveSale(sale), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Edit a Sale")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping(value = "/edit")
    public CustomResponse editSale(@RequestBody EditSaleRequestDTO sale) throws Exception {
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " ****** New requested function ****** ");
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " Starting editSale ... ");
        try {
            return new CustomResponse(this.saleService.editSale(sale), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Delete a Sale")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/delete/{id}")
    public CustomResponse deleteSale(@PathVariable Long id) throws Exception {
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " ****** New requested function ****** ");
        log.info(cl.thinka.salemicroservice.v1.controller.SaleController.class + " Starting deleteSale ... ");
        try {
            Boolean responseDTO = this.saleService.deleteSaleById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }


}
