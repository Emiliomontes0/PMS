package projectmanagementsystem.service;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.entity.Requirement;

import java.util.List;

public interface IssueService {
    List<Issue> getAllIssues();
    Issue saveIssues(Issue issue);
    Issue getIssueById(Long id);
    Issue updateIssue(Issue issue);
    void deleteIssueById(Long id);
    List<Issue> getAllIssuesById(Long id);
}
