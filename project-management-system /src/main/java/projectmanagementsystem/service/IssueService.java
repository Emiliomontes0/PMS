package projectmanagementsystem.service;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.entity.Requirement;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface IssueService {
    List<Issue> getAllIssues();
    Issue saveIssues(Issue issue);
    Issue getIssueById(Long id);
    Issue updateIssue(Issue issue);
    void deleteIssueById(Long id);
    List<Issue> getAllIssuesById(Long id);
}
