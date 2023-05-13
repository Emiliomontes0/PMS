package projectmanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.repository.RequirementRepository;
import projectmanagementsystem.service.RequirementService;

import java.util.ArrayList;
import java.util.List;
//LOOK AT ACTION ITEMS FOR EXPLANATION FOR FILE
@Service
public class RequirementServiceImpl implements RequirementService{
    private RequirementRepository requirementRepository;
    private ProjectRepository projectRepository;

    public RequirementServiceImpl(RequirementRepository requirementRepository, ProjectRepository projectRepository) {
        super();
        this.requirementRepository = requirementRepository;
        this.projectRepository = projectRepository;
    }
    @Override
    public List<Requirement> getAllRequirements(){
        return requirementRepository.findAll();
    }
    @Override
    public Requirement saveRequirements(Requirement requirement){
        return requirementRepository.save(requirement);
    }
    @Override
    public Requirement getRequirementById(Long id){
        return requirementRepository.findById(id).get();
    }
    public Requirement updateRequirement(Requirement requirement){
        return requirementRepository.save(requirement);
    }
    @Override
    public void deleteRequirementById(Long id){
        requirementRepository.deleteById(id);
    }
    @Override
    public List<Requirement> getAllRequirementsById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Requirement> assign = project.getRequirement();
        return assign;
    }

}
