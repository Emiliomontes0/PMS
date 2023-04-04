package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Issue;
import projectmanagementsystem.repository.IssueRepository;
import projectmanagementsystem.service.IssueService;

import java.util.List;
@Service
public class IssueServiceImpl implements IssueService{
    private IssueRepository issueRepository;

    public IssueServiceImpl(IssueRepository issueRepository) {
        super();
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
}
