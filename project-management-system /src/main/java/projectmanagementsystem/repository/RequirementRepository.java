package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
}
