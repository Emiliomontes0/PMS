package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
