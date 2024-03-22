package cl.thinka.projectmicroservice.v1.jpa.repository;

import cl.thinka.projectmicroservice.v1.jpa.entity.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository {

    Project save(Project project);

    boolean deleteById(Long id);

    Project getById(Long id);

    List<Project> getAll();

}
