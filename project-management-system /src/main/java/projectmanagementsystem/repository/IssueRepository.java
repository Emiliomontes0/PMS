package projectmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectmanagementsystem.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
