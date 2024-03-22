package cl.thinka.projectmicroservice.v1.controller;


import cl.thinka.projectmicroservice.v1.dto.ProjectDTO;
import cl.thinka.projectmicroservice.v1.dto.request.AddProjectRequestDTO;
import cl.thinka.projectmicroservice.v1.dto.request.EditProjectRequestDTO;
import cl.thinka.projectmicroservice.v1.enums.ResponseCode;
import cl.thinka.projectmicroservice.v1.service.impl.ProjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.thinka.projectmicroservice.v1.util.CustomResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/project")
@Log4j2
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;

    @Operation(summary = "List all active projects")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/list")
    public CustomResponse listProjects() throws Exception {
        log.info(ProjectController.class + " ****** New requested function ****** ");
        log.info(ProjectController.class + " Starting listProjects ... ");
        try {
            List<ProjectDTO> responseDTO = this.projectService.listProjects();
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Get a project by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/get/{id}")
    public CustomResponse getProjectById(@PathVariable Long id) throws Exception {
        log.info(ProjectController.class + " ****** New requested function ****** ");
        log.info(ProjectController.class + " Starting getProjectById ... ");
        try {
            ProjectDTO responseDTO = this.projectService.getProjectById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Create a new Project")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PostMapping(value = "/add")
    public CustomResponse addProject(@RequestBody AddProjectRequestDTO project) throws Exception {
        log.info(ProjectController.class + " ****** New requested function ****** ");
        log.info(ProjectController.class + " Starting addProject ... ");
        try {
            return new CustomResponse(this.projectService.saveProject(project), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Edit a Project")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @PutMapping(value = "/edit")
    public CustomResponse editProject(@RequestBody EditProjectRequestDTO project) throws Exception {
        log.info(ProjectController.class + " ****** New requested function ****** ");
        log.info(ProjectController.class + " Starting editProject ... ");
        try {
            return new CustomResponse(this.projectService.editProject(project), ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }

    @Operation(summary = "Delete a Project")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping(value = "/delete/{id}")
    public CustomResponse deleteProject(@PathVariable Long id) throws Exception {
        log.info(ProjectController.class + " ****** New requested function ****** ");
        log.info(ProjectController.class + " Starting deleteProject ... ");
        try {
            Boolean responseDTO = this.projectService.deleteProjectById(id);
            return new CustomResponse(responseDTO, ResponseCode.SUCCESSFUL.getCodError(), ResponseCode.SUCCESSFUL.getDescError());
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return new CustomResponse(ResponseCode.GENERAL_ERROR.getCodError(), ResponseCode.GENERAL_ERROR.getDescError());
        }
    }


}
