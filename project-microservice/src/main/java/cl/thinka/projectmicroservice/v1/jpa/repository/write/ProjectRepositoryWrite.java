package cl.thinka.projectmicroservice.v1.jpa.repository.write;

import cl.thinka.projectmicroservice.v1.jpa.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositoryWrite extends JpaRepository<Project, Long> {

    void deleteById(Long id);

}
