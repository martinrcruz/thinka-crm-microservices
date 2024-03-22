package cl.thinka.projectmicroservice.v1.jpa.repository.read;

import cl.thinka.projectmicroservice.v1.jpa.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProjectRepositoryRead extends JpaRepository<Project, Long> {
    Project getProjectById(Long id);

    List<Project> findAll();
}
