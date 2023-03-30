package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Risk;

public interface RiskRepository extends JpaRepository<Risk, Long> {
}
