package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
