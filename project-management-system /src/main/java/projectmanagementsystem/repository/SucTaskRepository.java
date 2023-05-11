package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.SucTask;

public interface SucTaskRepository extends JpaRepository<SucTask, Long> {
}
