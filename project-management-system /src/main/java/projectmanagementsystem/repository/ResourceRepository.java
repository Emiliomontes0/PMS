package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
