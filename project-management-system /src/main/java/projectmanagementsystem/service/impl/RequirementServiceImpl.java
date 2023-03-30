package projectmanagementsystem.service.impl;

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Requirement;
import projectmanagementsystem.repository.RequirementRepository;
import projectmanagementsystem.service.RequirementService;

import java.util.List;
@Service
public class RequirementServiceImpl implements RequirementService{
    private RequirementRepository requirementRepository;

    public RequirementServiceImpl(RequirementRepository requirementRepository) {
        super();
        this.requirementRepository = requirementRepository;
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
}
