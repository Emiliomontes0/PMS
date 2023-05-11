package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.PreTask;

public interface PreTaskRepository extends JpaRepository<PreTask, Long> {
}
