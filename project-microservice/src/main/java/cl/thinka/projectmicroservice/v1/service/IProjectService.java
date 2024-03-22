package cl.thinka.projectmicroservice.v1.service;

import cl.thinka.projectmicroservice.v1.dto.ProjectDTO;
import cl.thinka.projectmicroservice.v1.dto.request.AddProjectRequestDTO;
import cl.thinka.projectmicroservice.v1.dto.request.EditProjectRequestDTO;
import java.util.List;

public interface IProjectService {

    public List<ProjectDTO> listProjects() throws Exception;
    public ProjectDTO getProjectById(Long id) throws Exception;
    public Boolean deleteProjectById(Long id) throws Exception;
    public ProjectDTO editProject(EditProjectRequestDTO client) throws Exception;
    public ProjectDTO saveProject(AddProjectRequestDTO client) throws Exception;
}
