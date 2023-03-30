package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;

import java.util.List;

public interface RequirementService {
    List<Requirement> getAllRequirements();
    Requirement saveRequirements(Requirement requirement);
    Requirement getRequirementById(Long id);
    Requirement updateRequirement(Requirement requirement);
    void deleteRequirementById(Long id);
}
