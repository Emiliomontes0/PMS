package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Decision;

public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
