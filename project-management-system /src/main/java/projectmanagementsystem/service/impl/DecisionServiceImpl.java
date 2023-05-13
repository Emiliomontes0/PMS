package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Decision;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.DecisionRepository;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.service.DecisionService;

import java.util.List;
//THIS FILE FUNCTION AS THE CREATION FOR THE METHODS DEFINED IN SERVICE CLASSES
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
    }//USES REPOSITORY TO GRAB DATA FROM DATABASE
    @Override
    public Decision saveDecisions(Decision decision){
        return decisionRepository.save(decision);
    }//USES REPOSITORY TO SAVE OBJECT INTO DATABASE
    @Override
    public Decision getDecisionById(Long id){
        return decisionRepository.findById(id).get();
    }//USES REPOSITORY TO GRAB FROM DATABASE BY AN ID
    public Decision updateDecision(Decision decision){
        return decisionRepository.save(decision);
    }//USES REPOSITORY TO SAVE A OBJECT THAT HAS BEEN MODIFIED BY THE USERS
    @Override
    public void deleteDecisionById(Long id){
        decisionRepository.deleteById(id);
    }//USES REPOSITORY TO DELETE OBJECT IN DATA BASE WITH ID
    @Override
    public List<Decision> getAllDecisionsById(Long id){//CREATES A METHOD THAT ALLOWS GIVE RELATIONS BETWEEN OTHER OBJECT
        Project project = projectRepository.getById(id);//FIND THE RELATED PROJECT BY ID
        List<Decision> assign = project.getAssignDecision();//CREATES A LIST AND RETURNS THE LIST BACK TO WHERE METHOD IS CALLED
        return assign;
    }
}
