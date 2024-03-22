package cl.thinka.projectmicroservice.v1.service.impl;

import cl.thinka.projectmicroservice.v1.dto.ProjectDTO;
import cl.thinka.projectmicroservice.v1.dto.request.AddProjectRequestDTO;
import cl.thinka.projectmicroservice.v1.dto.request.EditProjectRequestDTO;
import cl.thinka.projectmicroservice.v1.jpa.entity.Project;
import cl.thinka.projectmicroservice.v1.jpa.repository.ProjectRepository;
import cl.thinka.projectmicroservice.v1.mapper.ProjectMapper;
import cl.thinka.projectmicroservice.v1.service.IProjectService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<ProjectDTO> listProjects() throws Exception {
        try {
            List<ProjectDTO> projectsDTO = new ArrayList<>();
            List<Project> projects = projectRepository.getAll();
            for (Project project : projects) {
                ProjectDTO projectDTO = new ProjectDTO();
                projectDTO = ProjectMapper.INSTANCE.toDto(project);
                projectsDTO.add(projectDTO);
            }
            return projectsDTO;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ProjectDTO getProjectById(Long id) throws Exception {
        ProjectDTO response = new ProjectDTO();
        try {
            Project project = projectRepository.getById(id);
            response = ProjectMapper.INSTANCE.toDto(project);
            return response;
        } catch (Exception e) {
            log.error("Error: " + e.getMessage());
            return response;
        }
    }

    @Override
    public Boolean deleteProjectById(Long id) throws Exception {
        try {
            return this.projectRepository.deleteById(id);
        } catch (Exception e) {
            log.error(ProjectServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public ProjectDTO editProject(EditProjectRequestDTO project) throws Exception {
        try {
            log.info(ProjectServiceImpl.class + " SUCCESS ");
            Project existingProject = this.projectRepository.getById(1L);

            if(existingProject != null){
                Project newProject = ProjectMapper.INSTANCE.toEntity(project);
                return ProjectMapper.INSTANCE.toDto(this.projectRepository.save(newProject));
            } else {
                log.error(ProjectServiceImpl.class + "Error: Cannot create project");
                return null;
            }
        } catch (Exception e) {
            log.error(ProjectServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public ProjectDTO saveProject(AddProjectRequestDTO project) throws Exception {
        try {
            Project newProject = ProjectMapper.INSTANCE.toEntity(project);
            log.info(ProjectServiceImpl.class + " SUCCESS ");
            return ProjectMapper.INSTANCE.toDto(this.projectRepository.save(newProject));
        } catch (Exception e) {
            log.error(ProjectServiceImpl.class + "Error" + e.getMessage());
            return null;
        }
    }
}
