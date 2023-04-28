package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.DecisionRepository;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.service.DecisionService;

import java.util.List;
@Service
public class DecisionServiceImpl implements DecisionService{
    private DecisionRepository decisionRepository;
    private ProjectRepository projectRepository;

    public DecisionServiceImpl(DecisionRepository decisionRepository, ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
        this.decisionRepository = decisionRepository;
    }
    @Override
    public List<Decision> getAllDecisions(){
        return decisionRepository.findAll();
    }
    @Override
    public Decision saveDecisions(Decision decision){
        return decisionRepository.save(decision);
    }
    @Override
    public Decision getDecisionById(Long id){
        return decisionRepository.findById(id).get();
    }
    public Decision updateDecision(Decision decision){
        return decisionRepository.save(decision);
    }
    @Override
    public void deleteDecisionById(Long id){
        decisionRepository.deleteById(id);
    }
    @Override
    public List<Decision> getAllDecisionsById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Decision> assign = project.getAssignDecision();
        return assign;
    }
}
