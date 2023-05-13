package projectmanagementsystem.service;
import projectmanagementsystem.entity.Requirement;

import java.util.List;
//THE PURPOSE OF THIS FILE IS TO CREATE FUNCTIONS THAT ARE USE BETWEEN THE USER AND MIDDLEWARE FOR BETTER CONTROL OF INFORMATION
//THIS FILE CAN ALSO BE USE TO CREATE NEW METHOD THAT ARE NEED AND AREN'T AUTO GENERATED THROUGH LIBRARYS
public interface RequirementService {
    List<Requirement> getAllRequirements();
    Requirement saveRequirements(Requirement requirement);
    Requirement getRequirementById(Long id);
    Requirement updateRequirement(Requirement requirement);
    void deleteRequirementById(Long id);
    List<Requirement> getAllRequirementsById(Long id);
}
