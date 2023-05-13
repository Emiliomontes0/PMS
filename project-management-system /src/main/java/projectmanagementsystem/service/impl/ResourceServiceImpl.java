package projectmanagementsystem.service.impl;
import org.springframework.stereotype.Service;
import projectmanagementsystem.entity.Project;
import projectmanagementsystem.entity.Resource;
import projectmanagementsystem.repository.ProjectRepository;
import projectmanagementsystem.repository.ResourceRepository;
import projectmanagementsystem.service.ResourceService;

import java.util.List;
//LOOK AT ACTION ITEMS FOR EXPLANATION FOR FILE
@Service
public class ResourceServiceImpl implements ResourceService{
    private ResourceRepository resourceRepository;
    private ProjectRepository projectRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
        this.resourceRepository = resourceRepository;
    }
    @Override
    public List<Resource> getAllResources(){
        return resourceRepository.findAll();
    }
    @Override
    public Resource saveResources(Resource task){
        return resourceRepository.save(task);
    }
    @Override
    public Resource getResourceById(Long id){
        return resourceRepository.findById(id).get();
    }
    public Resource updateResource(Resource task){
        return resourceRepository.save(task);
    }
    @Override
    public void deleteResourceById(Long id){
        resourceRepository.deleteById(id);
    }
    @Override
    public List<Resource> getAllResourcesById(Long id){//this is how to display relational requirements
        Project project = projectRepository.getById(id);
        List<Resource> assign = project.getAssignResource();
        return assign;
    }
}
