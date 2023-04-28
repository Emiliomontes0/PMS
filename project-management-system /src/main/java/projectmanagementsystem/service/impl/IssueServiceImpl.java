package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.IssueRepository;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.service.IssueService;

import java.util.List;
@Service
public class IssueServiceImpl implements IssueService{
    private IssueRepository issueRepository;
    private ProjectRepository projectRepository;

    public IssueServiceImpl(IssueRepository issueRepository, ProjectRepository projectRepository) {
        super();
        this.projectRepository=projectRepository;
        this.issueRepository = issueRepository;
    }
    @Override
    public List<Issue> getAllIssues(){
        return issueRepository.findAll();
    }
    @Override
    public Issue saveIssues(Issue issue){
        return issueRepository.save(issue);
    }
    @Override
    public Issue getIssueById(Long id){
        return issueRepository.findById(id).get();
    }
    public Issue updateIssue(Issue issue){
        return issueRepository.save(issue);
    }
    @Override
    public void deleteIssueById(Long id){
        issueRepository.deleteById(id);
    }
    @Override
    public List<Issue> getAllIssuesById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Issue> assign = project.getAssignIssue();
        return assign;
    }
}
