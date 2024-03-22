package cl.thinka.projectmicroservice.v1.jpa.repository.impl;

import cl.thinka.projectmicroservice.v1.jpa.entity.Project;
import cl.thinka.projectmicroservice.v1.jpa.repository.ProjectRepository;
import cl.thinka.projectmicroservice.v1.jpa.repository.read.ProjectRepositoryRead;
import cl.thinka.projectmicroservice.v1.jpa.repository.write.ProjectRepositoryWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    @Autowired
    ProjectRepositoryRead projectRepositoryRead;
    @Autowired
    ProjectRepositoryWrite projectRepositoryWrite;

    @Override
    public Project save(Project project) {
        return projectRepositoryWrite.save(project);
    }

    @Override
    public boolean deleteById(Long id) {
        projectRepositoryWrite.deleteById(id);
        return false;
    }

    @Override
    public Project getById(Long id) {
        return projectRepositoryRead.getProjectById(id);
    }

    @Override
    public List<Project> getAll() {
        return projectRepositoryRead.findAll();
    }
}
