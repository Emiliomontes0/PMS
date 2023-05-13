package projectmanagementsystem.service.impl;
//LOOK AT ACTION ITEMS FOR EXPLANATION FOR FILE

import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.RequirementRepository;
import projectmanagementsystem.service.ProjectService;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    private RequirementRepository requirementRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }
    @Override
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    @Override
    public Project saveProjects(Project project){
        return projectRepository.save(project);
    }
    @Override
    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }
    public Project updateProject(Project project){
        return projectRepository.save(project);
    }
    @Override
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }

}
