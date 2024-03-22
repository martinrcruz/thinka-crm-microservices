package cl.thinka.clientmicroservice.v1.controller;

import cl.thinka.clientmicroservice.v1.dto.ClientDTO;
import cl.thinka.clientmicroservice.v1.dto.request.AddClientRequestDTO;
import cl.thinka.clientmicroservice.v1.dto.request.EditClientRequestDTO;
import cl.thinka.clientmicroservice.v1.service.impl.ClientServiceImpl;
import cl.thinka.clientmicroservice.v1.enums.ResponseCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.thinka.clientmicroservice.v1.util.CustomResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/client")
@Log4j2
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @Operation(summary = "List all active clients")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/list")
    public CustomResponse listClients() throws Exception {
        log.info(ClientController.class + " ****** New requested function ****** ");
        log.info(ClientController.class + " Starting listClients ... ");
        try {
            List<ClientDTO> responseDTO = this.clientService.listClients();
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Get a client by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/get/{id}")
    public CustomResponse getClientById(@PathVariable Long id) throws Exception {
        log.info(ClientController.class + " ****** New requested function ****** ");
        log.info(ClientController.class + " Starting getClientById ... ");
        try {
            ClientDTO responseDTO = this.clientService.getClientById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Create a new Client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PostMapping(value = "/add")
    public CustomResponse addClient(@RequestBody AddClientRequestDTO client) throws Exception {
        log.info(ClientController.class + " ****** New requested function ****** ");
        log.info(ClientController.class + " Starting addClient ... ");
        try {
            return new CustomResponse(this.clientService.saveClient(client), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Edit a Client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping(value = "/edit")
    public CustomResponse editClient(@RequestBody EditClientRequestDTO client) throws Exception {
        log.info(ClientController.class + " ****** New requested function ****** ");
        log.info(ClientController.class + " Starting editClient ... ");
        try {
            return new CustomResponse(this.clientService.editClient(client), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Delete a Client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/delete/{id}")
    public CustomResponse deleteClient(@PathVariable Long id) throws Exception {
        log.info(ClientController.class + " ****** New requested function ****** ");
        log.info(ClientController.class + " Starting deleteClient ... ");
        try {
            Boolean responseDTO = this.clientService.deleteClientById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }


}
