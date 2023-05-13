package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.entity.Risk;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.RiskRepository;
import projectmanagementsystem.service.RiskService;

import java.util.List;
//LOOK AT ACTION ITEMS FOR EXPLANATION FOR FILE
@Service
public class RiskServiceImpl implements RiskService{
    private RiskRepository riskRepository;
    private ProjectRepository projectRepository;

    public RiskServiceImpl(RiskRepository riskRepository, ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
        this.riskRepository = riskRepository;
    }
    @Override
    public List<Risk> getAllRisks(){
        return riskRepository.findAll();
    }
    @Override
    public Risk saveRisks(Risk risk){
        return riskRepository.save(risk);
    }
    @Override
    public Risk getRiskById(Long id){
        return riskRepository.findById(id).get();
    }
    public Risk updateRisk(Risk risk){
        return riskRepository.save(risk);
    }
    @Override
    public void deleteRiskById(Long id){
        riskRepository.deleteById(id);
    }
    @Override
    public List<Risk> getAllRisksById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Risk> assign = project.getAssignRisk();
        return assign;
    }
}
