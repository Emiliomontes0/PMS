package projectmanagementsystem.service;
import projectmanagementsystem.entity.Issue;

import java.util.List;

public interface IssueService {
    List<Issue> getAllIssues();
    Issue saveIssues(Issue issue);
    Issue getIssueById(Long id);
    Issue updateIssue(Issue issue);
    void deleteIssueById(Long id);
}
